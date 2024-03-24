package com.c2ri.project.dto

import com.c2ri.project.domain.Question
import java.time.LocalDateTime

data class QuestionRequest(
        val questionId: Long,
        val userId: Long,
        val title: String,
        val content: String,
        val createdDate: LocalDateTime,
        val modifiedDate: LocalDateTime,
        val status: String
) {
    fun toDomain(): Question {
        return Question(
                questionId = this.questionId,
                userId = this.userId,
                title = this.title,
                content = this.content,
                status = this.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
    }

    fun updateDomain(question: Question): Question {
        return question.copy(
                questionId = this.questionId,
                userId = this.userId,
                title = this.title,
                content = this.content,
                status = this.status,
                modifiedDate = LocalDateTime.now()
        )
    }
}