package com.c2ri.project.dto.test.request

import java.time.LocalDateTime

data class StationRequest(
        val stationId: Long,
        val routeId: Long,
        val sequence: Int,
        val stationName: String,
        val roadNameAddress: String,
        val x: String,
        val y: String,
        val createdDate: LocalDateTime,
        val modifiedDate: LocalDateTime,
        val status: String
)