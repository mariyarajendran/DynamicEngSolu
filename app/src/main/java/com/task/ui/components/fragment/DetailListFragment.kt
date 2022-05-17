package com.task.ui.components.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.R
import com.task.data.dto.network.HomeListDetailModel
import com.task.data.dto.network.HomeListModel
import com.task.databinding.DetailListFragmentBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.adapter.HomeAdapter
import com.task.ui.components.adapter.HomeDetailAdapter
import com.task.ui.components.viewmodel.DetailListViewModel
import com.task.utils.SingleEvent
import com.task.utils.observeEvent
import com.task.utils.toGone

class DetailListFragment : BaseFragment(), View.OnClickListener {
    private lateinit var binding: DetailListFragmentBinding
    private var adapter: HomeDetailAdapter? = null

    companion object {
        fun newInstance() = DetailListFragment()
    }

    private lateinit var viewModelDetail: DetailListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailListFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelDetail = ViewModelProvider(this).get(DetailListViewModel::class.java)
        initRecyclerviewAdapter()
        observeViewModel()
    }


    override fun initOnClickListener() {
        binding.inlHomeDetailHeader.imgLeftArrowAppHeader.setOnClickListener(this)
        binding.inlHomeDetailHeader.imgCloseAppHeader.setOnClickListener(this)
    }

    override fun init() {
    }

    override fun appHeaderAction() {
        binding.inlHomeDetailHeader.tvTitleAppHeader.text =
            returnResString(R.string.app_name)
    }

    override fun observeViewModel() {
        observeEvent(viewModelDetail.openHomeDetailList, ::observerHomeDetailClickEvent)
    }

    private fun initRecyclerviewAdapter() {
        val layoutManager = LinearLayoutManager(activity)
        binding.rvHomeDetail.layoutManager = layoutManager
        adapter = context?.let {
            HomeDetailAdapter(it, viewModelDetail.homeDetailData(), viewModelDetail)
        }
        binding.rvHomeDetail.adapter = adapter
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.inlHomeDetailHeader.imgCloseAppHeader -> {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.homeFragment)
            }
            binding.inlHomeDetailHeader.imgLeftArrowAppHeader -> {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.homeFragment)
            }
        }
    }

    private fun observerHomeDetailClickEvent(event: SingleEvent<HomeListDetailModel>) {
        event.getContentIfNotHandled()?.let {
            Navigation.findNavController(binding.root)
                .navigate(R.id.detailFragment)
        }
    }

}