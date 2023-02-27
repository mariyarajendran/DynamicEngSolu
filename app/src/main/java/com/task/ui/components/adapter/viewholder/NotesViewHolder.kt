package com.task.ui.components.adapter.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.project.ProjectData
import com.task.databinding.ItemNotesBinding
import com.task.ui.components.callback.OnItemTapCallback


class NotesViewHolder(private val itemBinding: ItemNotesBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(
        context: Context,
        projectData: MutableList<ProjectData>,
        position: Int,
        onItemTapCallback: OnItemTapCallback
    ) {
        itemBinding.tvTitleItem.text = projectData[position].project_name
        itemBinding.tvDescriptionItem.text = projectData[position].project_name
        // itemBinding.imgItemHome.setImageDrawable(context.resources.getDrawable(homeListData[position].image))
        itemBinding.crdItemHome.setOnClickListener {
            onItemTapCallback.onItemTap(position)
        }
    }
}
