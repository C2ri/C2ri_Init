package com.c2ri.project.controller

import com.c2ri.project.domain.Survey
import com.c2ri.project.dto.test.request.SurveyRequest
import com.c2ri.project.service.SurveyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/survey")
class SurveyController(private val surveyService: SurveyService) {

    @PostMapping
    fun saveSurvey(@RequestBody surveyRequest: SurveyRequest): ResponseEntity<Void> {
        surveyService.saveSurvey(surveyRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllSurveys(): ResponseEntity<List<Survey>> {
        val surveys = surveyService.getAllSurveys()
        return ResponseEntity(surveys, HttpStatus.OK)
    }

    @GetMapping("/{surveyId}")
    fun getSurveyById(@PathVariable surveyId: Long): ResponseEntity<Survey> {
        val survey = surveyService.getSurveyById(surveyId)
        return survey?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping("/{surveyId}")
    fun updateSurvey(
            @PathVariable surveyId: Long,
            @RequestBody surveyRequest: SurveyRequest
    ): ResponseEntity<Void> {
        surveyService.updateSurvey(surveyId, surveyRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/{surveyId}")
    fun deleteSurvey(@PathVariable surveyId: Long): ResponseEntity<Void> {
        surveyService.deleteSurvey(surveyId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}