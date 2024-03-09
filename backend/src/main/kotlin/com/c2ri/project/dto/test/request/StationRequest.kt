package com.c2ri.project.dto.test.request

import java.time.LocalDateTime

data class StationRequest(
        val stationId: Long? = null,
        val routeId: Long,
        val sequence: Int,
        val stationName: String,
        val roadNameAddress: String,
        val x: String,
        val y: String,
        val createdDate: LocalDateTime? = null,
        val modifiedDate: LocalDateTime? = null,
        val status: String
)