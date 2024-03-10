package com.c2ri.project.controller

import com.c2ri.project.domain.Station
import com.c2ri.project.dto.test.request.StationRequest
import com.c2ri.project.service.StationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/station")
class StationController(private val stationService: StationService) {

    @PostMapping
    fun saveStation(@RequestBody stationRequest: StationRequest): ResponseEntity<Void> {
        stationService.saveStation(stationRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllStations(): ResponseEntity<List<Station>> {
        val stations = stationService.getAllStations()
        return ResponseEntity(stations, HttpStatus.OK)
    }

    @PostMapping("/find")
    fun getStationById(@RequestBody stationId: Long): ResponseEntity<Station> {
        val station = stationService.getStationById(stationId)
        return station?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping
    fun updateStation(@RequestBody stationRequest: StationRequest): ResponseEntity<Void> {
        stationService.updateStation(stationRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping
    fun deleteStation(@RequestBody stationId: Long): ResponseEntity<Void> {
        stationService.deleteStation(stationId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}