package com.task.ui.components.adapter.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.task.data.dto.network.LanguageModel
import com.task.databinding.ItemLanguageBinding
import com.task.ui.components.callback.OnItemTapCallback
import com.task.utils.toVisible


class LanguageViewHolder(private val itemBinding: ItemLanguageBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(
        context: Context,
        languageListData: MutableList<LanguageModel>,
        position: Int,
        onItemTapCallback: OnItemTapCallback
    ) {
        if (languageListData[position].language == "English")
            itemBinding.imgItemLanguageCurrent.toVisible()
        itemBinding.tvItemLanguageName.text = languageListData[position].language
    }
}
