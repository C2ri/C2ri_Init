package com.c2ri.project.controller

import com.c2ri.project.domain.Survey
import com.c2ri.project.dto.SurveyRequest
import com.c2ri.project.service.SurveyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "설문 관리", description = "설문 관리 API")
@RestController
@RequestMapping("/survey")
class SurveyController(private val surveyService: SurveyService) {

    @Operation(summary = "새로운 설문 생성")
    @PostMapping
    fun saveSurvey(@Parameter(description = "새로운 설문을 생성하기 위한 설문 상세 정보") @RequestBody surveyRequest: SurveyRequest): ResponseEntity<Void> {
        surveyService.saveSurvey(surveyRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @Operation(summary = "ID로 설문 가져오기")
    @PostMapping("/find")
    fun getSurveyById(@Parameter(description = "가져올 설문의 ID") @RequestBody surveyId: Long): ResponseEntity<Survey> {
        val survey = surveyService.getSurveyById(surveyId)
        return survey?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @Operation(summary = "설문 업데이트")
    @PutMapping
    fun updateSurvey(@Parameter(description = "기존 설문을 업데이트하기 위한 설문 상세 정보") @RequestBody surveyRequest: SurveyRequest): ResponseEntity<Void> {
        surveyService.updateSurvey(surveyRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @Operation(summary = "설문 삭제")
    @DeleteMapping
    fun deleteSurvey(@Parameter(description = "삭제할 설문의 ID") @RequestBody surveyId: Long): ResponseEntity<Void> {
        surveyService.deleteSurvey(surveyId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}