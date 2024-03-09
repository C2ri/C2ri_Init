package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "routes")
data class Route(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "routeId")
        val routeId: Long? = null,

        @Column(name = "departureLocation")
        var departureLocation: String,

        @Column(name = "arrivalLocation")
        var arrivalLocation: String,

        @Column(name = "departureTime")
        var departureTime: Int,

        @Column(name = "arrivalTime")
        var arrivalTime: Int,

        @Column(name = "estimatedTime")
        var estimatedTime: Int,

        @Column(name = "createdDate")
        val createdDate: LocalDateTime? = null,

        @Column(name = "modifiedDate")
        var modifiedDate: LocalDateTime? = null,

        @Column(name = "status")
        var status: String
)