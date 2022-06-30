package com.task.data

import com.task.data.dto.login.LoginRequest
import com.task.data.dto.login.LoginResponse
import com.task.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.flow.flowOn

class DataRepository @Inject constructor(
    private val remoteRepository: RemoteData,
    private val ioDispatcher: CoroutineContext
) : DataRepositorySource {
    override suspend fun doLogin(loginRequest: HashMap<String, String>): Flow<Resource<LoginResponse>> {
        return flow {
            emit(remoteRepository.requestLogin(loginRequest))
        }.flowOn(ioDispatcher)
    }
}
