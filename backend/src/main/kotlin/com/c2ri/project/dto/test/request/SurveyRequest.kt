package com.c2ri.project.dto.test.request

data class SurveyRequest(
        val surveyId: Long? = null,
        val rating: Int,
        val content: String,
        val userId: Long
)