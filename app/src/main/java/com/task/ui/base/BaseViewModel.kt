package com.task.ui.base

import androidx.lifecycle.ViewModel
import com.task.data.local.LocalData
import javax.inject.Inject


abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var errorManager: com.task.usecase.errors.ErrorManager

    @Inject
    lateinit var localRepository: LocalData

}
