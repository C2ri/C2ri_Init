package com.c2ri.project.controller

import com.c2ri.project.domain.Seat
import com.c2ri.project.dto.SeatRequest
import com.c2ri.project.service.SeatService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "좌석 관리", description = "좌석 관리 API")
@RestController
@RequestMapping("/seat")
class SeatController(private val seatService: SeatService) {

    @Operation(summary = "새로운 좌석 생성")
    @PostMapping
    fun saveSeat(@Parameter(description = "새로운 좌석을 생성하기 위한 좌석 상세 정보") @RequestBody seatRequest: SeatRequest): ResponseEntity<Void> {
        seatService.saveSeat(seatRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @Operation(summary = "모든 좌석 가져오기")
    @GetMapping
    fun getAllSeats(): ResponseEntity<List<Seat>> {
        val seats = seatService.getAllSeats()
        return ResponseEntity(seats, HttpStatus.OK)
    }

    @Operation(summary = "ID로 좌석 가져오기")
    @PostMapping("/find")
    fun getSeatById(@Parameter(description = "가져올 좌석의 ID") @RequestBody seatId: Long): ResponseEntity<Seat> {
        val seat = seatService.getSeatById(seatId)
        return seat?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @Operation(summary = "좌석 업데이트")
    @PutMapping
    fun updateSeat(@Parameter(description = "기존 좌석을 업데이트하기 위한 좌석 상세 정보") @RequestBody seatRequest: SeatRequest): ResponseEntity<Void> {
        seatService.updateSeat(seatRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @Operation(summary = "좌석 삭제")
    @DeleteMapping
    fun deleteSeat(@Parameter(description = "삭제할 좌석의 ID") @RequestBody seatId: Long): ResponseEntity<Void> {
        seatService.deleteSeat(seatId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}