package com.task.ui.base

import androidx.lifecycle.ViewModel
import java.util.logging.ErrorManager
import javax.inject.Inject


abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var errorManager: ErrorManager

}
