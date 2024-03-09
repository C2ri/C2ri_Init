package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "seats")
data class Seat(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "seatId")
        val seatId: Long? = null,

        @Column(name = "vehicleId")
        var vehicleId: Long,

        @Column(name = "routeId")
        var routeId: Long,

        @Column(name = "seatNumber")
        var seatNumber: Int,

        @Column(name = "modifiedDate")
        var modifiedDate: LocalDateTime? = null,

        @Column(name = "status")
        var status: String
)