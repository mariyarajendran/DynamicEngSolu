package com.task.data.dto.pdfnotes

data class PdfNotesResponse(
    val status_code: String = "",
    val msg: String = "",
    val data: MutableList<PdfNotesData> = mutableListOf()
)


data class PdfNotesData(
    val filename: String = "",
    val path: String = ""
)