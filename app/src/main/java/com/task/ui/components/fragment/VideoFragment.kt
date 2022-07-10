package com.task.ui.components.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.task.databinding.VideoFragmentBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.viewmodel.LanguageViewModel


class VideoFragment : BaseFragment(), View.OnClickListener {

    companion object {
        fun newInstance() = VideoFragment()
    }

    private lateinit var viewModel: LanguageViewModel
    private lateinit var binding: VideoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = VideoFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LanguageViewModel::class.java)
        init()
        initRecyclerviewAdapter()
        observeViewModel()
    }

    override fun initOnClickListener() {

    }

    override fun init() {

    }

    override fun appHeaderAction() {

    }

    override fun observeViewModel() {

    }

    override fun onClick(v: View) {

    }

    private fun initRecyclerviewAdapter() {

    }


}