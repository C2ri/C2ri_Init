package com.c2ri.project.controller

import com.c2ri.project.domain.Question
import com.c2ri.project.dto.QuestionRequest
import com.c2ri.project.service.QuestionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "질문 관리", description = "질문 관리 API")
@RestController
@RequestMapping("/question")
class QuestionController(private val questionService: QuestionService) {

    @Operation(summary = "새로운 질문 생성")
    @PostMapping
    fun saveQuestion(@Parameter(description = "새로운 질문을 생성하기 위한 질문 상세 정보") @RequestBody questionRequest: QuestionRequest): ResponseEntity<Void> {
        questionService.saveQuestion(questionRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @Operation(summary = "모든 질문 가져오기")
    @GetMapping
    fun getAllQuestions(): ResponseEntity<List<Question>> {
        val questions = questionService.getAllQuestions()
        return ResponseEntity(questions, HttpStatus.OK)
    }

    @Operation(summary = "ID로 질문 가져오기")
    @PostMapping("/find")
    fun getQuestionById(@Parameter(description = "가져올 질문의 ID") @RequestBody questionId: Long): ResponseEntity<Question> {
        val question = questionService.getQuestionById(questionId)
        return question?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @Operation(summary = "질문 업데이트")
    @PutMapping
    fun updateQuestion(@Parameter(description = "기존 질문을 업데이트하기 위한 질문 상세 정보") @RequestBody questionRequest: QuestionRequest): ResponseEntity<Void> {
        questionService.updateQuestion(questionRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @Operation(summary = "질문 삭제")
    @DeleteMapping
    fun deleteQuestion(@Parameter(description = "삭제할 질문의 ID") @RequestBody questionId: Long): ResponseEntity<Void> {
        questionService.deleteQuestion(questionId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}