package com.task.data

import com.task.data.dto.chapter.ChapterResponse
import com.task.data.dto.login.LoginResponse
import com.task.data.dto.project.ProjectResponse
import com.task.data.dto.subject.SubjectResponse
import kotlinx.coroutines.flow.Flow


interface DataRepositorySource {
    suspend fun doLogin(loginRequest: HashMap<String, String>): Flow<Resource<LoginResponse>>
    suspend fun userBasedProject(
        action: String,
        userId: String,
        orgId: String
    ): Flow<Resource<ProjectResponse>>

    suspend fun userBasedSubject(
        action: String,
        projectId: String,
        orgId: String
    ): Flow<Resource<SubjectResponse>>

    suspend fun userBasedChapter(
        action: String,
        subjectId: String,
        orgId: String
    ): Flow<Resource<ChapterResponse>>
}
