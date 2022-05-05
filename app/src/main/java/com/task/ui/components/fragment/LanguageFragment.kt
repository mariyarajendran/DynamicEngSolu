package com.task.ui.components.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.R
import com.task.databinding.LanguageFragmentBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.adapter.LanguageAdapter
import com.task.ui.components.viewmodel.LanguageViewModel
import com.task.utils.toGone


class LanguageFragment : BaseFragment(), View.OnClickListener {

    companion object {
        fun newInstance() = LanguageFragment()
    }

    private var adapter: LanguageAdapter? = null
    private lateinit var viewModel: LanguageViewModel
    private lateinit var binding: LanguageFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LanguageFragmentBinding.inflate(layoutInflater, container, false)
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
        binding.inlLanguageHeader.imgLeftArrowAppHeader.setOnClickListener(this)
    }

    override fun init() {

    }

    override fun appHeaderAction() {
        binding.inlLanguageHeader.tvTitleAppHeader.text =
            returnResString(R.string.title_language)

        binding.inlLanguageHeader.tvTitleAppHeader.textSize = 20.0F
        binding.inlLanguageHeader.imgCloseAppHeader.toGone()
    }

    override fun observeViewModel() {

    }

    override fun onClick(v: View) {
        when (v) {
            binding.inlLanguageHeader.imgLeftArrowAppHeader -> {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.homeFragment)
            }
        }
    }

    private fun initRecyclerviewAdapter() {
        val layoutManager = LinearLayoutManager(activity)
        binding.rvLanguage.layoutManager = layoutManager
        adapter = context?.let {
            LanguageAdapter(it, viewModel.languageData(), viewModel)
        }
        binding.rvLanguage.adapter = adapter
    }


}