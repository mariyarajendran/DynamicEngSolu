package com.task.ui.components.adapter.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.network.HomeListModel
import com.task.databinding.ItemHomeBinding
import com.task.ui.components.callback.OnItemTapCallback


class HomeViewHolder(private val itemBinding: ItemHomeBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(
        context: Context,
        homeListData: MutableList<HomeListModel>,
        position: Int,
        onItemTapCallback: OnItemTapCallback
    ) {
        itemBinding.tvTitleItem.text = homeListData[position].title
        itemBinding.tvDescriptionItem.text = homeListData[position].description
        itemBinding.imgItemHome.setImageDrawable(context.resources.getDrawable(homeListData[position].image))
        itemBinding.crdItemHome.setOnClickListener {
            onItemTapCallback.onItemTap(position)
        }
    }
}
