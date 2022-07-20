package com.task.ui.components.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.task.R
import com.task.data.Resource
import com.task.data.dto.chapter.ChapterData
import com.task.data.dto.chapter.ChapterResponse
import com.task.databinding.FragmentChapterBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.adapter.ChapterAdapter
import com.task.ui.components.viewmodel.NotesViewModel
import com.task.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChapterFragment : BaseFragment(), View.OnClickListener {
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var binding: FragmentChapterBinding
    private lateinit var chapterAdapter: ChapterAdapter
    private var subjectId = "0"
    private var subjectName = "";
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChapterBinding.inflate(layoutInflater, container, false)
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
        doUserBasedChapter()
    }

    override fun initOnClickListener() {
        binding.inlChapterHeader.imgSettingAppHeader.setOnClickListener(this)
    }

    override fun init() {

    }

    override fun appHeaderAction() {
        binding.inlChapterHeader.imgCloseAppHeader.toGone()
        binding.inlChapterHeader.imgLeftArrowAppHeader.toGone()
        binding.inlChapterHeader.imgSettingAppHeader.toVisible()
    }

    override fun observeViewModel() {
        observeEvent(notesViewModel.openChapterList, ::observerChapterClickEvent)
        observe(notesViewModel.chapterLiveData, ::handleChapterDetailResult)
    }

    override fun onClick(v: View) {

    }

    /// get chapter list api...
    private fun doUserBasedChapter() {
        notesViewModel.userBasedChapter(
            EnumUtils.CHAPTER_ACTION.value,
            subjectId,
            notesViewModel.getLoginResponseDataSession().org_id
        )
    }

    private fun initRecyclerviewAdapter() {
        val layoutManager = GridLayoutManager(activity, 2)
        binding.rvChapter.layoutManager = layoutManager
        binding.rvChapter.setHasFixedSize(true)
    }

    private fun bindDrawerData(chapterListsResponse: ChapterResponse) {
        if (!(chapterListsResponse.data.isNullOrEmpty())) {
            chapterAdapter =
                context?.let {
                    ChapterAdapter(it, chapterListsResponse.data, notesViewModel)
                }!!
            binding.rvChapter.adapter = chapterAdapter
        }
    }

    private fun handleChapterDetailResult(status: Resource<ChapterResponse>) {
        when (status) {
            is Resource.Loading -> {
            }

            is Resource.Success -> status.data?.let {
                bindDrawerData(it)
            }
            is Resource.DataError -> {
                status.errorCode?.let {
                    notesViewModel.showToastMessage(it)
                }
            }
            is Resource.Failure -> status.data?.let {
                it.let {
                    notesViewModel.showFailureToastMessage(it.msg)
                }
            }
            else -> {
            }
        }
    }


    private fun observerChapterClickEvent(event: SingleEvent<ChapterData>) {
        event.getContentIfNotHandled()?.let {
            val bundle = Bundle()
            bundle.putString(EnumUtils.CHAPTER_ID.value, it.chapter_id)
            bundle.putString(EnumUtils.CHAPTER_NAME.value, it.chapter_name)
//            Navigation.findNavController(binding.root)
//                .navigate(R.id.subjectFragment, bundle)
        }
    }

    private fun getArgumentData() {
        if (arguments != null) {
            subjectId = arguments?.getString(EnumUtils.SUBJECT_ID.value).toString()
            subjectName = arguments?.getString(EnumUtils.SUBJECT_NAME.value).toString()
            ///App Header Title
            binding.inlChapterHeader.tvTitleAppHeader.text =
                if (subjectName == "")
                    returnResString(R.string.app_name)
                else
                    subjectName
        }
    }
}