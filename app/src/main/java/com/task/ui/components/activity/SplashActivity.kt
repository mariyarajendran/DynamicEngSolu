package com.task.ui.components.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import com.task.R
import com.task.ui.base.BaseActivity
import com.task.ui.components.viewmodel.RegistrationViewModel
import com.task.utils.EnumIntUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {
    private val registrationViewModel: RegistrationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        splashRedirection()
    }

    override fun init() {

    }

    private fun splashRedirection() {
        registrationViewModel.getLoginSession().let {
            when (it) {
                true -> {
                    ///homeRedirection
                    splashRedirection(1)
                }
                else -> {
                    ///loginRedirection
                    splashRedirection(0)
                }
            }
        }
    }

    private fun splashRedirection(event: Int) {
        Handler().postDelayed({
            when (event) {
                EnumIntUtils.ZERO.code -> {
                    val loginIntent = Intent(this@SplashActivity, LoginActivity::class.java)
                    this@SplashActivity.startActivity(loginIntent)
                    this@SplashActivity.finish()
                }
                else -> {
                    val homeIntent = Intent(this@SplashActivity, HomeActivity::class.java)
                    this@SplashActivity.startActivity(homeIntent)
                    this@SplashActivity.finish()
                }
            }

        }, 3000)
    }

}