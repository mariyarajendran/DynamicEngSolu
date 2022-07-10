package com.task.ui.components.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.data.DataRepository
import com.task.data.DataRepositorySource
import com.task.data.Resource
import androidx.lifecycle.viewModelScope
import com.task.data.dto.login.LoginRequest
import com.task.data.dto.login.LoginResponse
import com.task.data.error.PASS_WORD_ERROR
import com.task.data.error.USER_NAME_ERROR
import com.task.ui.base.BaseViewModel
import com.task.utils.EnumUtils
import com.task.utils.NetworkConnectivity
import com.task.utils.RegexUtils.isValidEmail
import com.task.utils.SingleEvent
import com.task.utils.wrapEspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.collect


@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val mDataRepository: DataRepository,
    private val mDataRepositoryRepository: DataRepositorySource,
    private val mNetworkConnectivity: NetworkConnectivity,
) : BaseViewModel() {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val loginLiveDataPrivate = MutableLiveData<Resource<LoginResponse>>()
    val loginLiveData: LiveData<Resource<LoginResponse>> get() = loginLiveDataPrivate


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showSnackBarPrivate = MutableLiveData<SingleEvent<Any>>()
    val showSnackBar: LiveData<SingleEvent<Any>> get() = showSnackBarPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showToastPrivate = MutableLiveData<SingleEvent<Any>>()
    val showToast: LiveData<SingleEvent<Any>> get() = showToastPrivate

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        showToastPrivate.value = SingleEvent(error.description)
    }

    fun showFailureToastMessage(error: String) {
        showToastPrivate.value = SingleEvent(error)
    }

    fun doLogin(userEmail: String, passWord: String) {
        val isUserEmailValid = isValidEmail(userEmail)
        if (!isUserEmailValid) {
            loginLiveDataPrivate.value = Resource.DataError(USER_NAME_ERROR)
        } else if (passWord.isEmpty()) {
            loginLiveDataPrivate.value = Resource.DataError(PASS_WORD_ERROR)
        } else {
            viewModelScope.launch {
                loginLiveDataPrivate.value = Resource.Loading()
                print(loginLiveData.value?.data.toString())
                val loginRequest = HashMap<String, String>()
                loginRequest["username"] = userEmail
                loginRequest["password"] = passWord
                loginRequest["action"] = EnumUtils.LOGIN_ACTION.value
                //val loginRequest = LoginRequest("login_authentication", userEmail, passWord)
                wrapEspressoIdlingResource {
                    mDataRepositoryRepository.doLogin(
                        loginRequest
                    ).collect {
                        loginLiveDataPrivate.value = it
                    }
                }
            }
        }
    }

    fun getLoginSession(): Boolean {
        return localRepository.getLoginSession()
    }

}