package com.c2ri.project.service

import com.c2ri.project.domain.Question
import com.c2ri.project.dto.QuestionRequest
import com.c2ri.project.repository.QuestionRepository
import com.c2ri.project.util.CustomSecurityContextHolder
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class QuestionService(private val questionRepository: QuestionRepository) {

    private val logger = LoggerFactory.getLogger(QuestionService::class.java)

    fun saveQuestion(questionRequest: QuestionRequest) {
        questionRepository.save(questionRequest.toDomain())
    }

    fun getAllQuestions(): List<Question> {
        return questionRepository.findAll()
    }

    fun getQuestionById(questionId: Long): Question? {
        return questionRepository.findById(questionId).orElse(null)
    }

    fun updateQuestion(questionRequest: QuestionRequest) {
        val userId = CustomSecurityContextHolder.getSessionUserId() ?: throw IllegalArgumentException("User ID cannot be null")
        logger.info("Updating question: $questionRequest for user: $userId")
        val question = questionRepository.findByQuestionIdAndUserId(questionRequest.questionId, userId)
        if (question.isPresent) {
            questionRepository.save(questionRequest.updateDomain(question.get()))
        } else {
            throw IllegalArgumentException("Question not found or user not authorized")
        }
    }

    fun deleteQuestion(questionId: Long) {
        val userId = CustomSecurityContextHolder.getSessionUserId() ?: throw IllegalArgumentException("User ID cannot be null")
        logger.info("Deleting question with id : $questionId for user: $userId")
        val question = questionRepository.findByQuestionIdAndUserId(questionId, userId)
        if (question.isPresent) {
            questionRepository.delete(question.get())
        }
    }
}