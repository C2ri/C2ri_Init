package com.c2ri.project.controller

import StationRequest
import com.c2ri.project.domain.Station
import com.c2ri.project.service.StationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "역 관리", description = "역 관리 API")
@RestController
@RequestMapping("/station")
class StationController(private val stationService: StationService) {

    @Operation(summary = "새로운 역 생성")
    @PostMapping
    fun saveStation(@Parameter(description = "새로운 역을 생성하기 위한 역 상세 정보") @RequestBody stationRequest: StationRequest): ResponseEntity<Void> {
        stationService.saveStation(stationRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @Operation(summary = "모든 역 가져오기")
    @GetMapping
    fun getAllStations(): ResponseEntity<List<Station>> {
        val stations = stationService.getAllStations()
        return ResponseEntity(stations, HttpStatus.OK)
    }

    @Operation(summary = "ID로 역 가져오기")
    @PostMapping("/find")
    fun getStationById(@Parameter(description = "가져올 역의 ID") @RequestBody stationId: Long): ResponseEntity<Station> {
        val station = stationService.getStationById(stationId)
        return station?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @Operation(summary = "역 업데이트")
    @PutMapping
    fun updateStation(@Parameter(description = "기존 역을 업데이트하기 위한 역 상세 정보") @RequestBody stationRequest: StationRequest): ResponseEntity<Void> {
        stationService.updateStation(stationRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @Operation(summary = "역 삭제")
    @DeleteMapping
    fun deleteStation(@Parameter(description = "삭제할 역의 ID") @RequestBody stationId: Long): ResponseEntity<Void> {
        stationService.deleteStation(stationId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}