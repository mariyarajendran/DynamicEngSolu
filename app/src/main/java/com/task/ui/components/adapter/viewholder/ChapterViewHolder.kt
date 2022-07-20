package com.task.ui.components.adapter.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.chapter.ChapterData
import com.task.data.dto.project.ProjectData
import com.task.databinding.ItemNotesBinding
import com.task.ui.components.callback.OnItemTapCallback


class ChapterViewHolder(private val itemBinding: ItemNotesBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(
        context: Context,
        chapterData: MutableList<ChapterData>,
        position: Int,
        onItemTapCallback: OnItemTapCallback
    ) {
        itemBinding.tvTitleItem.text = chapterData[position].chapter_name
        itemBinding.tvDescriptionItem.text = chapterData[position].chapter_name
        // itemBinding.imgItemHome.setImageDrawable(context.resources.getDrawable(homeListData[position].image))
        itemBinding.crdItemHome.setOnClickListener {
            onItemTapCallback.onItemTap(position)
        }
    }
}
