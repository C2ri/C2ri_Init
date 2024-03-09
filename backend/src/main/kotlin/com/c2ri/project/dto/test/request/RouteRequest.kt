package com.c2ri.project.dto.test.request

import java.time.LocalDateTime

data class RouteRequest(
        val routeId: Long? = null,
        val departureLocation: String,
        val arrivalLocation: String,
        val departureTime: Int,
        val arrivalTime: Int,
        val estimatedTime: Int,
        val createdDate: LocalDateTime? = null,
        val modifiedDate: LocalDateTime? = null,
        val status: String
)