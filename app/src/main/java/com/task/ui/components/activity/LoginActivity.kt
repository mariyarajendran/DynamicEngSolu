package com.task.ui.components.activity

import android.content.Intent
import android.os.Bundle
import com.task.databinding.ActivityLoginBinding
import com.task.ui.base.BaseActivity

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initOnClickListener()
    }

    override fun init() {

    }

    private fun initOnClickListener() {
        binding.btnLoginSubmit.setOnClickListener {
            redirectToHome()
        }
    }

    private fun redirectToHome() {
        val mainIntent = Intent(this, HomeActivity::class.java)
        this.startActivity(mainIntent)
        this.finish()
    }

}