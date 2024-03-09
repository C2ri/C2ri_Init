package com.c2ri.project.dto.test.request

import java.time.LocalDateTime

data class SeatRequest(
        val seatId: Long? = null,
        val vehicleId: Long,
        val routeId: Long,
        val seatNumber: Int,
        val modifiedDate: LocalDateTime? = null,
        val status: String
)