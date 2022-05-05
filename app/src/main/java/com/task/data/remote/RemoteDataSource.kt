package com.task.data.remote

import com.task.data.Resource
import com.task.data.dto.credential.login.LoginRequest
import com.task.data.dto.credential.login.LoginResponse

internal interface RemoteDataSource {
    suspend fun requestLogin(loginRequest: LoginRequest): Resource<LoginResponse>
}
