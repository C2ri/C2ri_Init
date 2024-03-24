package com.c2ri.project.repository

import com.c2ri.project.domain.Question
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface QuestionRepository : JpaRepository<Question, Long> {
    fun findByQuestionIdAndUserId(questionId: Long, userId: Long): Optional<Question>
}