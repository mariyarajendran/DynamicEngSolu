package com.task.ui.components.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.chapter.ChapterData
import com.task.databinding.ItemNotesBinding
import com.task.ui.components.adapter.viewholder.ChapterViewHolder
import com.task.ui.components.callback.OnItemTapCallback
import com.task.ui.components.viewmodel.NotesViewModel

class ChapterAdapter(
    private val context: Context,
    private val chapterData: MutableList<ChapterData>,
    private val notesViewModel: NotesViewModel
) : RecyclerView.Adapter<ChapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val itemBinding =
            ItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChapterViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.bind(
            context,
            chapterData,
            position,
            onItemTapCallback
        )
    }

    override fun getItemCount(): Int {
        return chapterData.size
    }

    private val onItemTapCallback: OnItemTapCallback = object : OnItemTapCallback {
        override fun onItemTap(position: Int) {
            notesViewModel.onChapterSelected(chapterData, position)
        }
    }
}

