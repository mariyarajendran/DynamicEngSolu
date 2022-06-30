package com.task.data.remote

import com.task.data.Resource
import com.task.data.dto.login.LoginRequest
import com.task.data.dto.login.LoginResponse

internal interface RemoteDataSource {
    suspend fun requestLogin(loginRequest: HashMap<String, String>): Resource<LoginResponse>
}
