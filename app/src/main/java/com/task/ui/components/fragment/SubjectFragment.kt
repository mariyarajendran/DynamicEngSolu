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
import com.task.data.dto.subject.SubjectData
import com.task.data.dto.subject.SubjectResponse
import com.task.databinding.FragmentSubjectBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.adapter.SubjectAdapter
import com.task.ui.components.viewmodel.NotesViewModel
import com.task.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubjectFragment : BaseFragment(), View.OnClickListener {
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var binding: FragmentSubjectBinding
    private lateinit var subjectAdapter: SubjectAdapter
    private var projectId = "0"
    private var projectName = "";
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubjectBinding.inflate(layoutInflater, container, false)
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
        doUserBasedSubject()
    }

    override fun initOnClickListener() {
        binding.inlSubjectDetailHeader.imgSettingAppHeader.setOnClickListener(this)
    }

    override fun init() {

    }

    override fun appHeaderAction() {
        binding.inlSubjectDetailHeader.imgCloseAppHeader.toGone()
        binding.inlSubjectDetailHeader.imgLeftArrowAppHeader.toGone()
        binding.inlSubjectDetailHeader.imgSettingAppHeader.toGone()
    }

    override fun observeViewModel() {
        observeEvent(notesViewModel.openSubjectList, ::observerSubjectClickEvent)
        observe(notesViewModel.subjectLiveData, ::handleSubjectDetailResult)
    }

    override fun onClick(v: View) {

    }

    /// get subject list api...
    private fun doUserBasedSubject() {
        notesViewModel.userBasedSubject(
            EnumUtils.SUBJECT_ACTION.value,
            projectId,
            notesViewModel.getLoginResponseDataSession().org_id
        )
    }

    private fun initRecyclerviewAdapter() {
        val layoutManager = LinearLayoutManager(activity)
        binding.rvSubjectDetail.layoutManager = layoutManager
        binding.rvSubjectDetail.setHasFixedSize(true)
    }

    private fun bindDrawerData(subjectListsResponse: SubjectResponse) {
        if (!(subjectListsResponse.data.isNullOrEmpty())) {
            subjectAdapter =
                context?.let {
                    SubjectAdapter(it, subjectListsResponse.data, notesViewModel)
                }!!
            binding.rvSubjectDetail.adapter = subjectAdapter
        }
    }

    private fun handleSubjectDetailResult(status: Resource<SubjectResponse>) {
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


    private fun observerSubjectClickEvent(event: SingleEvent<SubjectData>) {
        event.getContentIfNotHandled()?.let {
            val bundle = Bundle()
            bundle.putString(EnumUtils.SUBJECT_ID.value, it.subject_id)
            bundle.putString(EnumUtils.SUBJECT_NAME.value, it.subject_name)
            Navigation.findNavController(binding.root)
                .navigate(R.id.chapterFragment, bundle)
        }
    }

    private fun getArgumentData() {
        if (arguments != null) {
            projectId = arguments?.getString(EnumUtils.PROJECT_ID.value).toString()
            projectName = arguments?.getString(EnumUtils.PROJECT_NAME.value).toString()
            ///App Header Title
            binding.inlSubjectDetailHeader.tvTitleAppHeader.text =
                if (projectName == "")
                    returnResString(R.string.app_name)
                else
                    projectName
        }
    }
}