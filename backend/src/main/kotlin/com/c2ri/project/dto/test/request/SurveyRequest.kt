package com.c2ri.project.dto.test.request

data class SurveyRequest(
        val surveyId: Long,
        val rating: Int,
        val content: String,
        val userId: Long
)