package com.c2ri.project.dto.test.request

import java.time.LocalDateTime

data class QuestionRequest(
        val questionId: Long,
        val userId: Long,
        val title: String,
        val content: String,
        val createdDate: LocalDateTime,
        val modifiedDate: LocalDateTime,
        val status: String
)