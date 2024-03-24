package com.c2ri.project.dto

import com.c2ri.project.domain.Notification
import java.time.LocalDateTime

class NotificationRequest (
        val notificationId: Long,
        val userId: Long,
        val notificationType: Int,
        val identifier: String,
        val status: String,
        val createdDate: LocalDateTime
) {
    fun toDomain(): Notification {
        return Notification(
                notificationId = this.notificationId,
                userId = this.userId,
                notificationType = this.notificationType,
                identifier = this.identifier,
                status = this.status,
                createdDate = LocalDateTime.now()
        )
    }

    fun updateDomain(notification: Notification): Notification {
        return notification.copy(
                notificationId = this.notificationId,
                userId = this.userId,
                notificationType = this.notificationType,
                identifier = this.identifier,
                status = this.status
        )
    }
}

class NotificationResponse (
        val notificationId: Long? = null,
        val userId: Long,
        val notificationType: Int,
        val identifier: String,
        val status: String,
        val createdDate: LocalDateTime
)