package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "vehicles")
data class Vehicle(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "vehicleId")
        val vehicleId: Long? = null,

        @Column(name = "routeId")
        var routeId: Long,

        @Column(name = "seatNumber")
        var seatNumber: Int,

        @Column(name = "manufacturingCompany")
        var manufacturingCompany: String,

        @Column(name = "vehicleNumber")
        var vehicleNumber: Int,

        @Column(name = "vehicleType")
        var vehicleType: String,

        @Column(name = "createdDate")
        val createdDate: LocalDateTime? = null,

        @Column(name = "modifiedDate")
        var modifiedDate: LocalDateTime? = null,

        @Column(name = "status")
        var status: String
)