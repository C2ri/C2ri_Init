package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "routes")
data class Route(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val routeId: Long? = null,

        var departureLocation: String,

        var arrivalLocation: String,

        var departureTime: Int,

        var arrivalTime: Int,

        var estimatedTime: Int,

        val createdDate: LocalDateTime? = null,

        var modifiedDate: LocalDateTime? = null,

        var status: String
)