package com.task.data

import com.task.data.dto.login.LoginResponse
import com.task.data.dto.project.ProjectResponse
import kotlinx.coroutines.flow.Flow


interface DataRepositorySource {
    suspend fun doLogin(loginRequest: HashMap<String, String>): Flow<Resource<LoginResponse>>
    suspend fun userBasedProject(
        action: String,
        userId: String,
        orgId: String
    ): Flow<Resource<ProjectResponse>>
}
