package com.c2ri.project.repository

import com.c2ri.project.domain.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long>