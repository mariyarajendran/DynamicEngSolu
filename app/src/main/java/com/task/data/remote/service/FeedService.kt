package com.task.data.remote.service

import com.task.data.dto.project.ProjectResponse
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
}
