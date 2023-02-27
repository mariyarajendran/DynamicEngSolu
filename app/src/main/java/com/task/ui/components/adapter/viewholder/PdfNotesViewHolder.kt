package com.task.ui.components.adapter.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.pdfnotes.PdfNotesData
import com.task.data.dto.subject.SubjectData
import com.task.databinding.ItemNotesPdfBinding
import com.task.databinding.ItemSubjectBinding
import com.task.ui.components.callback.OnItemTapCallback

class PdfNotesViewHolder(private val itemBinding: ItemNotesPdfBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(
        context: Context,
        pdfNotesData: MutableList<PdfNotesData>,
        position: Int,
        onItemTapCallback: OnItemTapCallback
    ) {
        itemBinding.tvDetailTitleItem.text = pdfNotesData[position].filename
        itemBinding.tvDetailDescriptionItem.text = pdfNotesData[position].filename
        itemBinding.crdItemNotesPdf.setOnClickListener {
            onItemTapCallback.onItemTap(position)
        }
    }
}