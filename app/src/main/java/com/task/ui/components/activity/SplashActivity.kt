package com.task.ui.components.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.task.R
import com.task.ui.base.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun observeViewModel() {

    }

    override fun initViewBinding() {

    }

    override fun init() {
        redirectToLogin()
    }

    private fun redirectToLogin() {
        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            this@SplashActivity.startActivity(mainIntent)
            this@SplashActivity.finish()
        }, 3000)
    }

}