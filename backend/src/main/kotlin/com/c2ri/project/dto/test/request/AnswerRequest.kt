package com.c2ri.project.dto.test.request

import java.time.LocalDateTime

data class AnswerRequest(
        val answerId: Long? = null,
        val questionId: Long,
        val userId: Long,
        val title: String,
        val content: String,
        val createdDate: LocalDateTime? = null,
        val modifiedDate: LocalDateTime? = null,
        val status: String
)