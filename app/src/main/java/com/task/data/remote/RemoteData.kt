package com.task.data.remote

import com.task.data.Resource
import com.task.data.dto.chapter.ChapterResponse
import com.task.data.dto.login.LoginResponse
import com.task.data.dto.pdfnotes.PdfNotesResponse
import com.task.data.dto.project.ProjectResponse
import com.task.data.dto.subject.SubjectResponse
import com.task.data.error.NETWORK_ERROR
import com.task.data.error.NO_INTERNET_CONNECTION
import com.task.data.local.LocalData
import com.task.data.remote.service.CredentialService
import com.task.data.remote.service.FeedService
import com.task.utils.NetworkConnectivity
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


class RemoteData @Inject
constructor(
    private val serviceGenerator: ServiceGenerator,
    private val networkConnectivity: NetworkConnectivity,
    private val localRepository: LocalData
) : RemoteDataSource {
    override suspend fun requestLogin(loginRequest: HashMap<String, String>): Resource<LoginResponse> {
        val loginService = serviceGenerator.createService(CredentialService::class.java)
        return when (val response = processCall { loginService.fetchLogin(loginRequest) }) {
            is LoginResponse -> {
                when (response.status_code) {
                    "1" -> {
                        localRepository.putLoginResponseData(response)
                        localRepository.putLoginSession(true)
                        Resource.Success(data = response)
                    }
                    else -> {
                        Resource.Failure(failureData = response)
                    }
                }
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    override suspend fun userBasedProject(
        action: String,
        userId: String,
        orgId: String
    ): Resource<ProjectResponse> {
        val feedService = serviceGenerator.createService(FeedService::class.java)
        return when (val response =
            processCall { feedService.userBasedProject(action, userId, orgId) }) {
            is ProjectResponse -> {
                when (response.status_code) {
                    "1" -> {
                        Resource.Success(data = response)
                    }
                    else -> {
                        Resource.Failure(failureData = response)
                    }
                }
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    override suspend fun userBasedSubject(
        action: String,
        projectId: String,
        orgId: String
    ): Resource<SubjectResponse> {
        val feedService = serviceGenerator.createService(FeedService::class.java)
        return when (val response =
            processCall { feedService.userBasedSubject(action, projectId, orgId) }) {
            is SubjectResponse -> {
                when (response.status_code) {
                    "1" -> {
                        Resource.Success(data = response)
                    }
                    else -> {
                        Resource.Failure(failureData = response)
                    }
                }
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    override suspend fun userBasedChapter(
        action: String,
        subjectId: String,
        orgId: String
    ): Resource<ChapterResponse> {
        val feedService = serviceGenerator.createService(FeedService::class.java)
        return when (val response =
            processCall { feedService.userBasedChapter(action, subjectId, orgId) }) {
            is ChapterResponse -> {
                when (response.status_code) {
                    "1" -> {
                        Resource.Success(data = response)
                    }
                    else -> {
                        Resource.Failure(failureData = response)
                    }
                }
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    override suspend fun userBasedPdfNotes(
        action: String,
        subjectId: String,
        orgId: String,
        chapterId: String
    ): Resource<PdfNotesResponse> {
        val feedService = serviceGenerator.createService(FeedService::class.java)
        return when (val response =
            processCall { feedService.userBasedPdfNotes(action, subjectId, orgId, chapterId) }) {
            is PdfNotesResponse -> {
                when (response.status_code) {
                    "1" -> {
                        Resource.Success(data = response)
                    }
                    else -> {
                        Resource.Failure(failureData = response)
                    }
                }
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }


    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }


}
