package com.task.data

import com.task.data.dto.chapter.ChapterResponse
import com.task.data.dto.login.LoginResponse
import com.task.data.dto.project.ProjectResponse
import com.task.data.dto.subject.SubjectResponse
import com.task.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(
    private val remoteRepository: RemoteData,
    private val ioDispatcher: CoroutineContext
) : DataRepositorySource {
    override suspend fun doLogin(loginRequest: HashMap<String, String>): Flow<Resource<LoginResponse>> {
        return flow {
            emit(remoteRepository.requestLogin(loginRequest))
        }.flowOn(ioDispatcher)
    }

    override suspend fun userBasedProject(
        action: String,
        userId: String,
        orgId: String
    ): Flow<Resource<ProjectResponse>> {
        return flow {
            emit(remoteRepository.userBasedProject(action, userId, orgId))
        }.flowOn(ioDispatcher)
    }

    override suspend fun userBasedSubject(
        action: String,
        projectId: String,
        orgId: String
    ): Flow<Resource<SubjectResponse>> {
        return flow {
            emit(remoteRepository.userBasedSubject(action, projectId, orgId))
        }
    }

    override suspend fun userBasedChapter(
        action: String,
        subjectId: String,
        orgId: String
    ): Flow<Resource<ChapterResponse>> {
        return flow {
            emit(remoteRepository.userBasedChapter(action, subjectId, orgId))
        }
    }
}