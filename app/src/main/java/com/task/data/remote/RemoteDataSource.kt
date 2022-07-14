package com.task.data.remote

import com.task.data.Resource
import com.task.data.dto.login.LoginResponse
import com.task.data.dto.project.ProjectResponse

internal interface RemoteDataSource {
    suspend fun requestLogin(loginRequest: HashMap<String, String>): Resource<LoginResponse>
    suspend fun userBasedProject(
        action: String,
        userId: String,
        orgId: String
    ): Resource<ProjectResponse>
}
