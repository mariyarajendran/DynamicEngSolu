package com.task.ui.components.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.network.HomeListModel
import com.task.databinding.ItemHomeBinding
import com.task.ui.components.adapter.viewholder.HomeViewHolder
import com.task.ui.components.callback.OnItemTapCallback
import com.task.ui.components.viewmodel.NotesViewModel

class NotesAdapter(
    private val context: Context,
    private val homeListData: MutableList<HomeListModel>,
    private val notesViewModel: NotesViewModel
) : RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemBinding =
            ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(
            context,
            homeListData,
            position,
            onItemTapCallback
        )
    }

    override fun getItemCount(): Int {
        return homeListData.size
    }

    private val onItemTapCallback: OnItemTapCallback = object : OnItemTapCallback {
        override fun onItemTap(position: Int) {
            notesViewModel.onHomeSelected(homeListData, position)
        }
    }
}

