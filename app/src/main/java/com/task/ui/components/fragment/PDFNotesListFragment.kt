package com.task.ui.components.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.R
import com.task.data.Resource
import com.task.data.dto.pdfnotes.PdfNotesData
import com.task.data.dto.pdfnotes.PdfNotesResponse
import com.task.databinding.FragmentPdfNotesListBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.adapter.PdfNotesAdapter
import com.task.ui.components.viewmodel.NotesViewModel
import com.task.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PDFNotesListFragment : BaseFragment(), View.OnClickListener {
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var binding: FragmentPdfNotesListBinding
    private lateinit var pdfNotesAdapter: PdfNotesAdapter
    private var chapterId = "0"
    private var subjectId = "0"
    private var chapterName = "";
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPdfNotesListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel =
            ViewModelProviders.of(this).get(NotesViewModel::class.java)
        getArgumentData()
        init()
        initRecyclerviewAdapter()
        observeViewModel()
        doUserBasedPdfNotes()
    }

    override fun initOnClickListener() {
        binding.inlPdfNotesListHeader.imgSettingAppHeader.setOnClickListener(this)
    }

    override fun init() {

    }

    override fun appHeaderAction() {
        binding.inlPdfNotesListHeader.imgCloseAppHeader.toGone()
        binding.inlPdfNotesListHeader.imgLeftArrowAppHeader.toGone()
        binding.inlPdfNotesListHeader.imgSettingAppHeader.toGone()
    }

    override fun observeViewModel() {
        observeEvent(notesViewModel.openPdfNotes, ::observerPdfNotesClickEvent)
        observe(notesViewModel.pdfNotesLiveData, ::handlePdfNotesResult)
    }

    override fun onClick(v: View) {

    }

    /// get pdf notes list api...
    private fun doUserBasedPdfNotes() {
        notesViewModel.userBasedPdfNotes(
            EnumUtils.PDF_NOTES_ACTION.value,
            subjectId,
            notesViewModel.getLoginResponseDataSession().org_id,
            chapterId,
        )
    }

    private fun initRecyclerviewAdapter() {
        val layoutManager = LinearLayoutManager(activity)
        binding.rvPdfNotesList.layoutManager = layoutManager
        binding.rvPdfNotesList.setHasFixedSize(true)
    }

    private fun bindDrawerData(pdfNotesResponse: PdfNotesResponse) {
        if (!(pdfNotesResponse.data.isNullOrEmpty())) {
            pdfNotesAdapter =
                context?.let {
                    PdfNotesAdapter(it, pdfNotesResponse.data, notesViewModel)
                }!!
            binding.rvPdfNotesList.adapter = pdfNotesAdapter
        }
    }

    private fun handlePdfNotesResult(status: Resource<PdfNotesResponse>) {
        when (status) {
            is Resource.Loading -> binding.progressBar.toVisible()

            is Resource.Success -> status.data?.let {
                binding.progressBar.toGone()
                bindDrawerData(it)
            }
            is Resource.DataError -> {
                binding.progressBar.toGone()
                status.errorCode?.let {
                    notesViewModel.showToastMessage(it)
                }
            }
            is Resource.Failure -> status.data?.let {
                binding.progressBar.toGone()
                it.let {
                    notesViewModel.showFailureToastMessage(it.msg)
                }
            }
            else -> {
            }
        }
    }


    private fun observerPdfNotesClickEvent(event: SingleEvent<PdfNotesData>) {
        event.getContentIfNotHandled()?.let {
            val bundle = Bundle()
            bundle.putString(EnumUtils.PDF_FILENAME.value, it.filename)
            bundle.putString(EnumUtils.PDF_FILEPATH.value, it.path)
            Navigation.findNavController(binding.root)
                .navigate(R.id.pdfNotesFragment, bundle)
        }
    }

    private fun getArgumentData() {
        if (arguments != null) {
            chapterId = arguments?.getString(EnumUtils.CHAPTER_ID.value).toString()
            subjectId = arguments?.getString(EnumUtils.SUBJECT_ID.value).toString()
            chapterName = arguments?.getString(EnumUtils.CHAPTER_NAME.value).toString()
            ///App Header Title
            binding.inlPdfNotesListHeader.tvTitleAppHeader.text =
                if (chapterName == "")
                    returnResString(R.string.app_name)
                else
                    chapterName
        }
    }
}