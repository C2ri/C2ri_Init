package com.c2ri.project.service

import com.c2ri.project.domain.Answer
import com.c2ri.project.dto.test.request.AnswerRequest
import com.c2ri.project.repository.AnswerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class AnswerService(private val answerRepository: AnswerRepository) {

    fun saveAnswer(answerRequest: AnswerRequest) {
        val answer = Answer(
                questionId = answerRequest.questionId,
                userId = answerRequest.userId,
                title = answerRequest.title,
                content = answerRequest.content,
                status = answerRequest.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
        answerRepository.save(answer)
    }

    @Transactional(readOnly = true)
    fun getAllAnswers(): List<Answer> {
        return answerRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getAnswerById(answerId: Long): Answer? {
        return answerRepository.findById(answerId).orElse(null)
    }

    fun updateAnswer(answerRequest: AnswerRequest) {
        val answer = answerRepository.findById(answerRequest.answerId)
        if (answer.isPresent) {
            answer.get().apply {
                questionId = answerRequest.questionId
                userId = answerRequest.userId
                title = answerRequest.title
                content = answerRequest.content
                status = answerRequest.status
                modifiedDate = LocalDateTime.now()
            }
        }
    }

    fun deleteAnswer(answerId: Long) {
        answerRepository.deleteById(answerId)
    }
}