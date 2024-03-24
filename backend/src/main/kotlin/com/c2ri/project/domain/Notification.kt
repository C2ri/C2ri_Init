package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "notifications")
data class Notification(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val notificationId: Long? = null,

        var userId: Long,

        var notificationType: Int,

        var identifier: String,

        var status: String,

        var createdDate: LocalDateTime
)