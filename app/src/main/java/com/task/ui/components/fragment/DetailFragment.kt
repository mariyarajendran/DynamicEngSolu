package com.task.ui.components.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.task.R
import com.task.YOUTUBE_LINK
import com.task.YOUTUBE_PACKAGE
import com.task.databinding.DetailFragmentBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.viewmodel.DetailViewModel

class DetailFragment : BaseFragment(), View.OnClickListener {
    private lateinit var binding: DetailFragmentBinding
    private var intent = Intent(Intent.ACTION_VIEW)

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var detailViewModel: DetailViewModel

    override fun initOnClickListener() {
        binding.inlDetailHeader.imgCloseAppHeader.setOnClickListener(this)
        binding.inlDetailHeader.imgLeftArrowAppHeader.setOnClickListener(this)
        binding.tvDetailVideoNameOne.setOnClickListener(this)
        binding.tvDetailVideoNameTwo.setOnClickListener(this)
    }

    override fun init() {
        intent.data = Uri.parse(YOUTUBE_LINK)
    }

    override fun appHeaderAction() {
        binding.inlDetailHeader.tvTitleAppHeader.text =
            returnResString(R.string.lable_about_cancer)
    }

    override fun observeViewModel() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.inlDetailHeader.imgCloseAppHeader -> {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.homeFragment)
            }
            binding.inlDetailHeader.imgLeftArrowAppHeader -> {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.detailListFragment)
            }
            binding.tvDetailVideoNameOne -> {
                intent.setPackage(YOUTUBE_PACKAGE)
                startActivity(intent)
            }
            binding.tvDetailVideoNameTwo -> {
                intent.setPackage(YOUTUBE_PACKAGE)
                startActivity(intent)
            }
        }
    }

}