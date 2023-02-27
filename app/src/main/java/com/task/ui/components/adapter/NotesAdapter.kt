package com.task.ui.components.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.project.ProjectData
import com.task.databinding.ItemNotesBinding
import com.task.ui.components.adapter.viewholder.NotesViewHolder
import com.task.ui.components.callback.OnItemTapCallback
import com.task.ui.components.viewmodel.NotesViewModel

class NotesAdapter(
    private val context: Context,
    private val projectData: MutableList<ProjectData>,
    private val notesViewModel: NotesViewModel
) : RecyclerView.Adapter<NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemBinding =
            ItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(
            context,
            projectData,
            position,
            onItemTapCallback
        )
    }

    override fun getItemCount(): Int {
        return projectData.size
    }

    private val onItemTapCallback: OnItemTapCallback = object : OnItemTapCallback {
        override fun onItemTap(position: Int) {
             notesViewModel.onProjectSelected(projectData, position)
        }
    }
}

