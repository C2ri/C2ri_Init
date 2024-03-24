package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "stations")
data class Station(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val stationId: Long? = null,

        var routeId: Long,

        var sequence: Int,

        var stationName: String,

        var roadNameAddress: String,

        var x: String,

        var y: String,

        val createdDate: LocalDateTime? = null,

        var modifiedDate: LocalDateTime? = null,

        var status: String
)