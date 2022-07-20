package com.task.ui.components.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.task.R
import com.task.data.Resource
import com.task.data.dto.project.ProjectData
import com.task.data.dto.project.ProjectResponse
import com.task.databinding.NotesFragmentBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.adapter.NotesAdapter
import com.task.ui.components.viewmodel.NotesViewModel
import com.task.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : BaseFragment(), View.OnClickListener {
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var binding: NotesFragmentBinding
    private lateinit var notesAdapter: NotesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NotesFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel =
            ViewModelProviders.of(this).get(NotesViewModel::class.java)
        init()
        initRecyclerviewAdapter()
        observeViewModel()
        doUserBasedProject()
    }

    override fun initOnClickListener() {
        binding.inlNotesHeader.imgSettingAppHeader.setOnClickListener(this)
    }

    override fun init() {

    }

    override fun appHeaderAction() {
        binding.inlNotesHeader.tvTitleAppHeader.text =
            returnResString(R.string.app_name)
        binding.inlNotesHeader.imgCloseAppHeader.toGone()
        binding.inlNotesHeader.imgLeftArrowAppHeader.toGone()
        binding.inlNotesHeader.imgSettingAppHeader.toVisible()
    }

    override fun observeViewModel() {
        observeEvent(notesViewModel.openProjectList, ::observerProjectClickEvent)
        observe(notesViewModel.projectLiveData, ::handleProjectDetailResult)
    }

    override fun onClick(v: View) {

    }

    /// get project list api...
    private fun doUserBasedProject() {
        notesViewModel.userBasedProject(
            EnumUtils.PROJECT_ACTION.value,
            notesViewModel.getLoginResponseDataSession().user_id,
            notesViewModel.getLoginResponseDataSession().org_id
        )
    }

    private fun initRecyclerviewAdapter() {
        val layoutManager = GridLayoutManager(activity, 2)
        binding.rvNotes.layoutManager = layoutManager
        binding.rvNotes.setHasFixedSize(true)
    }

    private fun bindDrawerData(projectListsResponse: ProjectResponse) {
        if (!(projectListsResponse.data.isNullOrEmpty())) {
            notesAdapter =
                context?.let {
                    NotesAdapter(it, projectListsResponse.data, notesViewModel)
                }!!
            binding.rvNotes.adapter = notesAdapter
        }
    }

    private fun handleProjectDetailResult(status: Resource<ProjectResponse>) {
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


    private fun observerProjectClickEvent(event: SingleEvent<ProjectData>) {
        event.getContentIfNotHandled()?.let {
            val bundle = Bundle()
            bundle.putString(EnumUtils.PROJECT_ID.value, it.project_id)
            bundle.putString(EnumUtils.PROJECT_NAME.value, it.project_name)
            Navigation.findNavController(binding.root)
                .navigate(R.id.subjectFragment, bundle)
        }
    }
}