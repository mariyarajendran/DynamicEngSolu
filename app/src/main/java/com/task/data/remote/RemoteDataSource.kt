package com.task.data.remote

import com.task.data.Resource
import com.task.data.dto.chapter.ChapterResponse
import com.task.data.dto.login.LoginResponse
import com.task.data.dto.project.ProjectResponse
import com.task.data.dto.subject.SubjectResponse

internal interface RemoteDataSource {
    suspend fun requestLogin(loginRequest: HashMap<String, String>): Resource<LoginResponse>
    suspend fun userBasedProject(
        action: String,
        userId: String,
        orgId: String
    ): Resource<ProjectResponse>

    suspend fun userBasedSubject(
        action: String,
        projectId: String,
        orgId: String
    ): Resource<SubjectResponse>

    suspend fun userBasedChapter(
        action: String,
        subjectId: String,
        orgId: String
    ): Resource<ChapterResponse>
}
