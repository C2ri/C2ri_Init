package com.c2ri.project.repository

import com.c2ri.project.domain.Answer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AnswerRepository : JpaRepository<Answer, Long> {
    fun findByAnswerIdAndUserId(answerId: Long, userId: Long): Optional<Answer>
}