package com.c2ri.project.dto.test.request

import java.time.LocalDateTime

data class VehicleRequest(
        val vehicleId: Long? = null,
        val seatNumber: Int,
        val manufacturingCompany: String,
        val vehicleNumber: Int,
        val vehicleType: String,
        val createdDate: LocalDateTime? = null,
        val modifiedDate: LocalDateTime? = null,
        val status: String
)