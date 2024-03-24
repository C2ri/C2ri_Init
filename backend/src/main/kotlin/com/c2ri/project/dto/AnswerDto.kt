package com.c2ri.project.dto

import com.c2ri.project.domain.Answer
import java.time.LocalDateTime

data class AnswerRequest(
        val answerId: Long,
        val questionId: Long,
        val userId: Long,
        val title: String,
        val content: String,
        val createdDate: LocalDateTime,
        val modifiedDate: LocalDateTime,
        val status: String
) {
    fun toDomain(): Answer {
        return Answer(
                answerId = this.answerId,
                questionId = this.questionId,
                userId = this.userId,
                title = this.title,
                content = this.content,
                status = this.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
    }

    fun updateDomain(answer: Answer): Answer {
        return answer.copy(
                answerId = this.answerId,
                questionId = this.questionId,
                userId = this.userId,
                title = this.title,
                content = this.content,
                status = this.status,
                modifiedDate = LocalDateTime.now()
        )
    }
}