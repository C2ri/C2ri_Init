package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "vehicles")
data class Vehicle(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val vehicleId: Long? = null,

        var routeId: Long,

        var seatNumber: Int,

        var manufacturingCompany: String,

        var vehicleNumber: Int,

        var vehicleType: String,

        val createdDate: LocalDateTime? = null,

        var modifiedDate: LocalDateTime? = null,

        var status: String
)