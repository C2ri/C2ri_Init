package com.c2ri.project.dto.test.response

import java.time.LocalDateTime

class NotificationResponse (
    val notificationId: Long? = null,
    val userId: Long,
    val notificationType: Int,
    val identifier: String,
    val status: String,
    val createdDate: LocalDateTime
)