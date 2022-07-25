package com.task.ui.components.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.pdfnotes.PdfNotesData
import com.task.databinding.ItemNotesPdfBinding
import com.task.ui.components.adapter.viewholder.PdfNotesViewHolder
import com.task.ui.components.callback.OnItemTapCallback
import com.task.ui.components.viewmodel.NotesViewModel

class PdfNotesAdapter(
    private val context: Context,
    private val pdfNotesData: MutableList<PdfNotesData>,
    private val notesViewModel: NotesViewModel
) : RecyclerView.Adapter<PdfNotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdfNotesViewHolder {
        val itemBinding =
            ItemNotesPdfBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PdfNotesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PdfNotesViewHolder, position: Int) {
        holder.bind(
            context,
            pdfNotesData,
            position,
            onItemTapCallback
        )
    }

    override fun getItemCount(): Int {
        return pdfNotesData.size
    }

    private val onItemTapCallback: OnItemTapCallback = object : OnItemTapCallback {
        override fun onItemTap(position: Int) {
            notesViewModel.onNotesPdfSelected(pdfNotesData, position)
        }
    }
}

