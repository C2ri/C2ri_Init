package com.c2ri.project.repository

import com.c2ri.project.domain.Survey
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SurveyRepository : JpaRepository<Survey, Long> {
    fun findBySurveyIdAndUserId(surveyId: Long, userId: Long): Optional<Survey>
}