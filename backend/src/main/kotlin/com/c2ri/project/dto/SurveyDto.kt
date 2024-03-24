package com.c2ri.project.dto

import com.c2ri.project.domain.Survey

data class SurveyRequest(
        val surveyId: Long,
        val rating: Int,
        val content: String,
        val userId: Long
) {
    fun toDomain(): Survey {
        return Survey(
                surveyId = this.surveyId,
                rating = this.rating,
                content = this.content,
                userId = this.userId
        )
    }

    fun updateDomain(survey: Survey): Survey {
        return survey.copy(
                surveyId = this.surveyId,
                rating = this.rating,
                content = this.content,
                userId = this.userId
        )
    }
}