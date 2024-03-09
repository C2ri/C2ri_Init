package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "stations")
data class Station(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "stationId")
        val stationId: Long? = null,

        @Column(name = "routeId")
        var routeId: Long,

        @Column(name = "sequence")
        var sequence: Int,

        @Column(name = "stationName")
        var stationName: String,

        @Column(name = "roadNameAddress")
        var roadNameAddress: String,

        @Column(name = "x")
        var x: String,

        @Column(name = "y")
        var y: String,

        @Column(name = "createdDate")
        val createdDate: LocalDateTime? = null,

        @Column(name = "modifiedDate")
        var modifiedDate: LocalDateTime? = null,

        @Column(name = "status")
        var status: String
)