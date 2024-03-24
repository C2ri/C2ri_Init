package com.c2ri.project.controller

import com.c2ri.project.domain.Answer
import com.c2ri.project.dto.AnswerRequest
import com.c2ri.project.service.AnswerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "답변 관리", description = "답변 관리 API")
@RestController
@RequestMapping("/answer")
class AnswerController(private val answerService: AnswerService) {

    @Operation(summary = "답변 생성")
    @PostMapping
    fun saveAnswer(@Parameter(description = "새로운 답변을 생성하기 위한 답변 상세 정보") @RequestBody answerRequest: AnswerRequest): ResponseEntity<Void> {
        answerService.saveAnswer(answerRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @Operation(summary = "모든 답변 가져오기")
    @GetMapping
    fun getAllAnswers(): ResponseEntity<List<Answer>> {
        val answers = answerService.getAllAnswers()
        return ResponseEntity(answers, HttpStatus.OK)
    }

    @Operation(summary = "ID로 답변 가져오기")
    @PostMapping("/find")
    fun getAnswerById(@Parameter(description = "가져올 답변의 ID") @RequestBody answerId: Long): ResponseEntity<Answer> {
        val answer = answerService.getAnswerById(answerId)
        return answer?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @Operation(summary = "답변 업데이트")
    @PutMapping
    fun updateAnswer(@Parameter(description = "기존 답변을 업데이트하기 위한 답변 상세 정보") @RequestBody answerRequest: AnswerRequest): ResponseEntity<Void> {
        answerService.updateAnswer(answerRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @Operation(summary = "답변 삭제")
    @DeleteMapping
    fun deleteAnswer(@Parameter(description = "삭제할 답변의 ID") @RequestBody answerId: Long): ResponseEntity<Void> {
        answerService.deleteAnswer(answerId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}