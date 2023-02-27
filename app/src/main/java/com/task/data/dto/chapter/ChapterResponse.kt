package com.task.data.dto.chapter

data class ChapterResponse(
    val status_code: String = "",
    val msg: String = "",
    val data: MutableList<ChapterData> = mutableListOf()
)


data class ChapterData(
    val chapter_id: String = "",
    val chapter_name: String = ""
)