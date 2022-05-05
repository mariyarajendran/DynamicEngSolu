package com.task.ui.components.viewmodel

import androidx.lifecycle.ViewModel
import com.task.data.dto.network.LanguageModel

class LanguageViewModel : ViewModel() {

    fun languageData(): MutableList<LanguageModel> {
        val languageModel1 = LanguageModel(
            "Tamil",
        )
        val languageModel2 = LanguageModel(
            "English",
        )

        val languageList = mutableListOf<LanguageModel>()
        languageList.add(languageModel1)
        languageList.add(languageModel2)
        return languageList
    }
}