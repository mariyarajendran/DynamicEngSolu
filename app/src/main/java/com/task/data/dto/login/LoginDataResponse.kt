package com.task.data.dto.credential.login

val languageData = Language(id = 0, name = "", code = "")

data class LoginDataResponse(
    val id: Int = 0,
    val token: String = "",
    val first_name: String = "",
    val last_name: String = "",
    val employee_user_name: String = "",
    val email: String = "",
    val role_id: Int = 0,
    val is_active: Boolean = false,
    var language: Language = languageData
)

data class Language(
    var id: Int = 0,
    var name: String = "",
    var code: String = "",
)