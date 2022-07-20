package com.task.data.remote.service

import com.task.data.dto.chapter.ChapterResponse
import com.task.data.dto.project.ProjectResponse
import com.task.data.dto.subject.SubjectResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface FeedService {
    @GET("dms/mobile_api.php")
    suspend fun userBasedProject(
        @Query(value = "action") action: String,
        @Query(value = "user_id") userId: String,
        @Query(value = "org_id") orgId: String
    ): Response<ProjectResponse>

    @GET("dms/mobile_api.php")
    suspend fun userBasedSubject(
        @Query(value = "action") action: String,
        @Query(value = "project_id") projectId: String,
        @Query(value = "org_id") orgId: String
    ): Response<SubjectResponse>

    @GET("dms/mobile_api.php")
    suspend fun userBasedChapter(
        @Query(value = "action") action: String,
        @Query(value = "subject_id") subjectId: String,
        @Query(value = "org_id") orgId: String
    ): Response<ChapterResponse>
}
