package com.c2ri.project.controller

import com.c2ri.project.domain.Seat
import com.c2ri.project.dto.test.request.SeatRequest
import com.c2ri.project.service.SeatService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/seat")
class SeatController(private val seatService: SeatService) {

    @PostMapping
    fun saveSeat(@RequestBody seatRequest: SeatRequest): ResponseEntity<Void> {
        seatService.saveSeat(seatRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllSeats(): ResponseEntity<List<Seat>> {
        val seats = seatService.getAllSeats()
        return ResponseEntity(seats, HttpStatus.OK)
    }

    @PostMapping("/find")
    fun getSeatById(@RequestBody seatId: Long): ResponseEntity<Seat> {
        val seat = seatService.getSeatById(seatId)
        return seat?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping
    fun updateSeat(@RequestBody seatRequest: SeatRequest): ResponseEntity<Void> {
        seatService.updateSeat(seatRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping
    fun deleteSeat(@RequestBody seatId: Long): ResponseEntity<Void> {
        seatService.deleteSeat(seatId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}