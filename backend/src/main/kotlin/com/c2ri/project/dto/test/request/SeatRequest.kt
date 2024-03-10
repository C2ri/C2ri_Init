package com.c2ri.project.dto.test.request

import java.time.LocalDateTime

data class SeatRequest(
        val seatId: Long,
        val vehicleId: Long,
        val routeId: Long,
        val seatNumber: Int,
        val modifiedDate: LocalDateTime,
        val status: String
)