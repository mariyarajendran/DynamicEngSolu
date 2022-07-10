package com.task.ui.components.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.task.R
import com.task.data.dto.network.HomeListModel
import com.task.databinding.NotesFragmentBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.adapter.NotesAdapter
import com.task.ui.components.viewmodel.NotesViewModel
import com.task.utils.SingleEvent
import com.task.utils.observeEvent
import com.task.utils.toGone
import com.task.utils.toVisible


class NotesFragment : BaseFragment(), View.OnClickListener {
    private var adapter: NotesAdapter? = null
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var binding: NotesFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NotesFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        init()
        initRecyclerviewAdapter()
        observeViewModel()
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
        observeEvent(notesViewModel.openHomeList, ::observerHomeClickEvent)
    }

    override fun onClick(v: View) {

    }


    private fun initRecyclerviewAdapter() {
        val layoutManager = GridLayoutManager(activity, 2)
        binding.rvNotes.layoutManager = layoutManager
        adapter = context?.let {
            NotesAdapter(it, notesViewModel.homeData(), notesViewModel)
        }
        binding.rvNotes.adapter = adapter
    }

    private fun observerHomeClickEvent(event: SingleEvent<HomeListModel>) {
        event.getContentIfNotHandled()?.let {
            Navigation.findNavController(binding.root)
                .navigate(R.id.detailListFragment)
        }
    }
}