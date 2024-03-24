package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "seats")
data class Seat(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val seatId: Long? = null,

        var vehicleId: Long,

        var routeId: Long,

        var seatNumber: Int,

        var modifiedDate: LocalDateTime? = null,

        var status: String
)