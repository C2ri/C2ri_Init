package com.c2ri.project.repository

import com.c2ri.project.domain.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository : JpaRepository<Answer, Long>