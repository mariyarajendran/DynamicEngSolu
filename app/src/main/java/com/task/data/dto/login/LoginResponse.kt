package com.task.data.dto.login

data class LoginResponse(
    val msg: String = "",
    val status_code: String = "",
    val user_id: String = "",
    val org_id: String = "",
    val user_email: String = "",
    val org_logo: String = "",
    val terms_of_conditions: String = "",
    val about_us: String = "",
    val customer_support: String = "",
)


