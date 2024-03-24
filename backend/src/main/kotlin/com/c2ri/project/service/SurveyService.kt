package com.c2ri.project.service

import com.c2ri.project.domain.Survey
import com.c2ri.project.dto.SurveyRequest
import com.c2ri.project.repository.SurveyRepository
import com.c2ri.project.util.CustomSecurityContextHolder
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SurveyService(private val surveyRepository: SurveyRepository) {

    private val logger = LoggerFactory.getLogger(SurveyService::class.java)

    fun saveSurvey(surveyRequest: SurveyRequest) {
        surveyRepository.save(surveyRequest.toDomain())
    }

    fun getAllSurveys(): List<Survey> {
        return surveyRepository.findAll()
    }

    fun getSurveyById(surveyId: Long): Survey? {
        return surveyRepository.findById(surveyId).orElse(null)
    }

    fun updateSurvey(surveyRequest: SurveyRequest) {
        val userId = CustomSecurityContextHolder.getSessionUserId() ?: throw IllegalArgumentException("User ID cannot be null")
        logger.info("Updating survey: $surveyRequest for user: $userId")
        val survey = surveyRepository.findBySurveyIdAndUserId(surveyRequest.surveyId, userId)
        if (survey.isPresent) {
            surveyRepository.save(surveyRequest.updateDomain(survey.get()))
        } else {
            throw IllegalArgumentException("Survey not found or user not authorized")
        }
    }

    fun deleteSurvey(surveyId: Long) {
        val userId = CustomSecurityContextHolder.getSessionUserId() ?: throw IllegalArgumentException("User ID cannot be null")
        logger.info("Deleting survey with id : $surveyId for user: $userId")
        val survey = surveyRepository.findBySurveyIdAndUserId(surveyId, userId)
        if (survey.isPresent) {
            surveyRepository.delete(survey.get())
        }
    }
}