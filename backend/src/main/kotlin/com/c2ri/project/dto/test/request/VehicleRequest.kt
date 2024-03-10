package com.c2ri.project.dto.test.request

import java.time.LocalDateTime

data class VehicleRequest(
        val vehicleId: Long,
        val routeId: Long,
        val seatNumber: Int,
        val manufacturingCompany: String,
        val vehicleNumber: Int,
        val vehicleType: String,
        val createdDate: LocalDateTime,
        val modifiedDate: LocalDateTime,
        val status: String
)