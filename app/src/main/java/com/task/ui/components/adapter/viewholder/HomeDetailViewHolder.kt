package com.task.ui.components.adapter.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.network.HomeListDetailModel
import com.task.databinding.ItemHomeDetailBinding
import com.task.ui.components.callback.OnItemTapCallback

class HomeDetailViewHolder(private val itemBinding: ItemHomeDetailBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(
        context: Context,
        homeDetailListData: MutableList<HomeListDetailModel>,
        position: Int,
        onItemTapCallback: OnItemTapCallback
    ) {
        itemBinding.tvDetailTitleItem.text = homeDetailListData[position].title
        itemBinding.tvDetailDescriptionItem.text = homeDetailListData[position].description
        itemBinding.crdItemHomeDetail.setOnClickListener {
            onItemTapCallback.onItemTap(position)
        }
    }
}