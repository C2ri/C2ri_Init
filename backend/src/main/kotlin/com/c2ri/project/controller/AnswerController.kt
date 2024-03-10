package com.c2ri.project.controller

import com.c2ri.project.domain.Answer
import com.c2ri.project.dto.test.request.AnswerRequest
import com.c2ri.project.service.AnswerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/answer")
class AnswerController(private val answerService: AnswerService) {

    @PostMapping
    fun saveAnswer(@RequestBody answerRequest: AnswerRequest): ResponseEntity<Void> {
        answerService.saveAnswer(answerRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllAnswers(): ResponseEntity<List<Answer>> {
        val answers = answerService.getAllAnswers()
        return ResponseEntity(answers, HttpStatus.OK)
    }

    @PostMapping("/find")
    fun getAnswerById(@RequestBody answerId: Long): ResponseEntity<Answer> {
        val answer = answerService.getAnswerById(answerId)
        return answer?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping
    fun updateAnswer(@RequestBody answerRequest: AnswerRequest): ResponseEntity<Void> {
        answerService.updateAnswer(answerRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/{answerId}")
    fun deleteAnswer(@PathVariable answerId: Long): ResponseEntity<Void> {
        answerService.deleteAnswer(answerId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}