package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "notifications")
data class Notification(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "notificationId")
        val notificationId: Long? = null,

        @Column(name = "userId")
        var userId: Long,

        @Column(name = "notificationType")
        var notificationType: Int,

        @Column(name = "identifier")
        var identifier: String,

        @Column(name = "status")
        var status: String,

        @Column(name = "createdDate")
        var createdDate: LocalDateTime
)