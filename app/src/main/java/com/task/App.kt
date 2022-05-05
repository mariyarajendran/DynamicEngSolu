package com.task

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

open class App : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
    }
}