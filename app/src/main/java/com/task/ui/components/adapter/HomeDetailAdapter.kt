package com.task.ui.components.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.network.HomeListDetailModel
import com.task.databinding.ItemHomeDetailBinding
import com.task.ui.components.adapter.viewholder.HomeDetailViewHolder
import com.task.ui.components.callback.OnItemTapCallback
import com.task.ui.components.viewmodel.DetailListViewModel


class HomeDetailAdapter(
    private val context: Context,
    private val homeDetailListData: MutableList<HomeListDetailModel>,
    private val homeDetailViewModel: DetailListViewModel
) : RecyclerView.Adapter<HomeDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeDetailViewHolder {
        val itemBinding =
            ItemHomeDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeDetailViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HomeDetailViewHolder, position: Int) {
        holder.bind(
            context,
            homeDetailListData,
            position,
            onItemTapCallback
        )
    }

    override fun getItemCount(): Int {
        return homeDetailListData.size
    }

    private val onItemTapCallback: OnItemTapCallback = object : OnItemTapCallback {
        override fun onItemTap(position: Int) {
            homeDetailViewModel.onHomeDetailSelected(homeDetailListData, position)
        }
    }
}

