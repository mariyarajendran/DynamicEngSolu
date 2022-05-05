package com.task.ui.components.activity

import android.os.Bundle
import com.task.R
import com.task.ui.base.BaseActivity


class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
    }

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
    }

    override fun init() {
    }

}