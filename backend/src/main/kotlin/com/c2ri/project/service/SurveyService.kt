package com.c2ri.project.service

import com.c2ri.project.domain.Survey
import com.c2ri.project.dto.test.request.SurveyRequest
import com.c2ri.project.repository.SurveyRepository
import org.springframework.stereotype.Service

@Service
class SurveyService(private val surveyRepository: SurveyRepository) {

    fun saveSurvey(surveyRequest: SurveyRequest) {
        val survey = Survey(
                rating = surveyRequest.rating,
                content = surveyRequest.content,
                userId = surveyRequest.userId
        )
        surveyRepository.save(survey)
    }

    fun getAllSurveys(): List<Survey> {
        return surveyRepository.findAll()
    }

    fun getSurveyById(surveyId: Long): Survey? {
        return surveyRepository.findById(surveyId).orElse(null)
    }

    fun updateSurvey(surveyRequest: SurveyRequest) {
        val survey = surveyRepository.findById(surveyRequest.surveyId)
        if (survey.isPresent) {
            survey.get().apply {
                rating = surveyRequest.rating
                content = surveyRequest.content
                userId = surveyRequest.userId
            }
            surveyRepository.save(survey.orElseThrow())
        }
    }

    fun deleteSurvey(surveyId: Long) {
        surveyRepository.deleteById(surveyId)
    }
}