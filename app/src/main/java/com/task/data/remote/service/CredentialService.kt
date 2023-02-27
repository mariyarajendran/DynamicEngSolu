package com.task.data.remote.service

import com.task.data.dto.login.LoginResponse
import retrofit2.Response
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface CredentialService {
    @POST("dms/mobile_api.php")
    @FormUrlEncoded
    suspend fun fetchLogin(@FieldMap loginRequest: HashMap<String, String>): Response<LoginResponse>
}
