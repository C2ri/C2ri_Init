package com.c2ri.project.dto.test.request

import java.time.LocalDateTime

class NotificationRequest (
    val notificationId: Long? = null,
    val userId: Long,
    val notificationType: Int,
    val identifier: String,
    val status: String,
    val createdDate: LocalDateTime
)