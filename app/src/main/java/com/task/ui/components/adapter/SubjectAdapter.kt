package com.task.ui.components.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.subject.SubjectData
import com.task.databinding.ItemSubjectBinding
import com.task.ui.components.adapter.viewholder.SubjectViewHolder
import com.task.ui.components.callback.OnItemTapCallback
import com.task.ui.components.viewmodel.NotesViewModel

class SubjectAdapter(
    private val context: Context,
    private val subjectData: MutableList<SubjectData>,
    private val notesViewModel: NotesViewModel
) : RecyclerView.Adapter<SubjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val itemBinding =
            ItemSubjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubjectViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind(
            context,
            subjectData,
            position,
            onItemTapCallback
        )
    }

    override fun getItemCount(): Int {
        return subjectData.size
    }

    private val onItemTapCallback: OnItemTapCallback = object : OnItemTapCallback {
        override fun onItemTap(position: Int) {
            notesViewModel.onSubjectSelected(subjectData, position)
        }
    }
}

