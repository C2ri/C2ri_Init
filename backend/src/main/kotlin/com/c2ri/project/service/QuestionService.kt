package com.c2ri.project.service

import com.c2ri.project.domain.Question
import com.c2ri.project.dto.test.request.QuestionRequest
import com.c2ri.project.repository.QuestionRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class QuestionService(private val questionRepository: QuestionRepository) {

    fun saveQuestion(questionRequest: QuestionRequest) {
        val question = Question(
                userId = questionRequest.userId,
                title = questionRequest.title,
                content = questionRequest.content,
                status = questionRequest.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
        questionRepository.save(question)
    }

    fun getAllQuestions(): List<Question> {
        return questionRepository.findAll()
    }

    fun getQuestionById(questionId: Long): Question? {
        return questionRepository.findById(questionId).orElse(null)
    }

    fun updateQuestion(questionId: Long, questionRequest: QuestionRequest) {
        val question = questionRepository.findById(questionId)
        if (question.isPresent) {
            question.get().apply {
                title = questionRequest.title
                content = questionRequest.content
                status = questionRequest.status
                modifiedDate = LocalDateTime.now()
            }
        }
    }

    fun deleteQuestion(questionId: Long) {
        questionRepository.deleteById(questionId)
    }
}