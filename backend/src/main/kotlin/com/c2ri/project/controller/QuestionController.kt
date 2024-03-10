package com.c2ri.project.controller

import com.c2ri.project.domain.Question
import com.c2ri.project.dto.test.request.QuestionRequest
import com.c2ri.project.service.QuestionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/question")
class QuestionController(private val questionService: QuestionService) {

    @PostMapping
    fun saveQuestion(@RequestBody questionRequest: QuestionRequest): ResponseEntity<Void> {
        questionService.saveQuestion(questionRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllQuestions(): ResponseEntity<List<Question>> {
        val questions = questionService.getAllQuestions()
        return ResponseEntity(questions, HttpStatus.OK)
    }

    @PostMapping("/find")
    fun getQuestionById(@RequestBody questionId: Long): ResponseEntity<Question> {
        val question = questionService.getQuestionById(questionId)
        return question?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping
    fun updateQuestion(@RequestBody questionRequest: QuestionRequest): ResponseEntity<Void> {
        questionService.updateQuestion(questionRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping
    fun deleteQuestion(@RequestBody questionId: Long): ResponseEntity<Void> {
        questionService.deleteQuestion(questionId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}