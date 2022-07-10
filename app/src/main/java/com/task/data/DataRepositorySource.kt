package com.task.data

import com.task.data.dto.login.LoginRequest
import com.task.data.dto.login.LoginResponse
import kotlinx.coroutines.flow.Flow


interface DataRepositorySource {
    suspend fun doLogin(loginRequest: HashMap<String, String>): Flow<Resource<LoginResponse>>
}
