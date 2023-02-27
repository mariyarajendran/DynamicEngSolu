package com.task.ui.components.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import com.google.android.material.snackbar.Snackbar
import com.task.data.Resource
import com.task.data.dto.login.LoginResponse
import com.task.databinding.ActivityLoginBinding
import com.task.ui.base.BaseActivity
import com.task.ui.components.viewmodel.RegistrationViewModel
import com.task.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {
    private val loginViewModel: RegistrationViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnLoginSubmit.setOnClickListener {
            it?.hideKeyboard()
            doLogin()
        }
    }

    override fun observeViewModel() {
        observe(loginViewModel.loginLiveData, ::handleLoginResult)
        observeToast(loginViewModel.showToast)
    }

    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initOnClickListener()
    }

    override fun init() {

    }

    private fun doLogin() {
        loginViewModel.doLogin(
            binding.edtLoginUsername.text?.trim().toString(),
            binding.edtLoginPassword.text.toString(),
        )
    }


    private fun observeToast(event: LiveData<SingleEvent<Any>>) {
        binding.root.showToast(this, event, Snackbar.LENGTH_LONG)
    }

    private fun initOnClickListener() {

    }

    private fun handleLoginResult(status: Resource<LoginResponse>) {
        when (status) {
            is Resource.Loading -> binding.progressBar.toVisible()
            is Resource.Success -> status.data?.let {
                binding.progressBar.toGone()
                if (it.status_code == "1") {
                    loginViewModel.showFailureToastMessage(it.msg)
                    redirectToHome()
                } else {
                    loginViewModel.showFailureToastMessage(it.msg)
                }
            }
            is Resource.DataError -> {
                binding.progressBar.toGone()
                status.errorCode?.let {
                    loginViewModel.showToastMessage(it)
                }
            }
            is Resource.Failure -> status.data?.let {
                binding.progressBar.toGone()
            }
            else -> {
            }
        }
    }

    private fun redirectToHome() {
        val mainIntent = Intent(this, HomeActivity::class.java)
        this.startActivity(mainIntent)
        this.finish()
    }

}