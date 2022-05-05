package com.task.ui.components.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.network.LanguageModel
import com.task.databinding.ItemLanguageBinding
import com.task.ui.components.adapter.viewholder.LanguageViewHolder
import com.task.ui.components.callback.OnItemTapCallback
import com.task.ui.components.viewmodel.LanguageViewModel

class LanguageAdapter(
    private val context: Context,
    private val languageListData: MutableList<LanguageModel>,
    private val languageViewHolder: LanguageViewModel
) : RecyclerView.Adapter<LanguageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val itemBinding =
            ItemLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LanguageViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.bind(
            context,
            languageListData,
            position,
            onItemTapCallback
        )
    }

    override fun getItemCount(): Int {
        return languageListData.size
    }

    private val onItemTapCallback: OnItemTapCallback = object : OnItemTapCallback {
        override fun onItemTap(position: Int) {

        }
    }
}

