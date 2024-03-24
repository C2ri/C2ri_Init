package com.c2ri.project.service

import com.c2ri.project.domain.Answer
import com.c2ri.project.dto.AnswerRequest
import com.c2ri.project.repository.AnswerRepository
import com.c2ri.project.util.CustomSecurityContextHolder
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AnswerService(private val answerRepository: AnswerRepository) {

    private val logger = LoggerFactory.getLogger(AnswerService::class.java)

    fun saveAnswer(answerRequest: AnswerRequest) {
        logger.info("Saving answer: $answerRequest")
        answerRepository.save(answerRequest.toDomain())
    }

    @Transactional(readOnly = true)
    fun getAllAnswers(): List<Answer> {
        logger.info("Getting all answers")
        return answerRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getAnswerById(answerId: Long): Answer? {
        logger.info("Getting answer by id: $answerId")
        return answerRepository.findById(answerId).orElse(null)
    }

    fun updateAnswer(answerRequest: AnswerRequest) {
        val userId = CustomSecurityContextHolder.getSessionUserId() ?: throw IllegalArgumentException("User ID cannot be null")
        logger.info("Updating answer: $answerRequest for user: $userId")
        val answer = answerRepository.findByAnswerIdAndUserId(answerRequest.answerId, userId)
        if (answer.isPresent) {
            answerRepository.save(answerRequest.updateDomain(answer.get()))
        } else {
            throw IllegalArgumentException("Answer not found or user not authorized")
        }
    }

    fun deleteAnswer(answerId: Long) {
        val userId = CustomSecurityContextHolder.getSessionUserId() ?: throw IllegalArgumentException("User ID cannot be null")
        logger.info("Deleting answer with id : $answerId for user: $userId")
        val answer = answerRepository.findByAnswerIdAndUserId(answerId, userId)
        if (answer.isPresent) {
            answerRepository.delete(answer.get())
        }
    }
}