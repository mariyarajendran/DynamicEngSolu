package com.task.data.dto.project

data class ProjectResponse(
    val status_code: String = "",
    val msg: String = "",
    val data: MutableList<ProjectData> = mutableListOf()
)


data class ProjectData(
    val project_id: String = "",
    val project_name: String = ""
)