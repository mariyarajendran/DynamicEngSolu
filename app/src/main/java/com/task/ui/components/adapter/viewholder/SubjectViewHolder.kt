package com.task.ui.components.adapter.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.subject.SubjectData
import com.task.databinding.ItemSubjectBinding
import com.task.ui.components.callback.OnItemTapCallback

class SubjectViewHolder(private val itemBinding: ItemSubjectBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(
        context: Context,
        subjectData: MutableList<SubjectData>,
        position: Int,
        onItemTapCallback: OnItemTapCallback
    ) {
        itemBinding.tvDetailTitleItem.text = subjectData[position].subject_name
        itemBinding.tvDetailDescriptionItem.text = subjectData[position].subject_name
        itemBinding.crdItemSubjectDetail.setOnClickListener {
            onItemTapCallback.onItemTap(position)
        }
    }
}