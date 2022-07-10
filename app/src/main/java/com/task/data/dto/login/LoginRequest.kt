package com.task.data.dto.login


data class LoginRequest(
    val action: String = "",
    val username: String = "",
    val password: String = ""
)
