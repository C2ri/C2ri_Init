package com.c2ri.project.service

import com.c2ri.project.domain.Notification
import com.c2ri.project.dto.test.request.NotificationRequest
import com.c2ri.project.repository.NotificationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NotificationService(
        private val notificationRepository: NotificationRepository
) {

    @Transactional
    fun saveNotification(notificationRequest: NotificationRequest) {
        val notification = Notification(
                userId = notificationRequest.userId,
                notificationType = notificationRequest.notificationType,
                identifier = notificationRequest.identifier,
                status = notificationRequest.status,
                createdDate = notificationRequest.createdDate
        )
        notificationRepository.save(notification)
    }

    @Transactional(readOnly = true)
    fun getNotificationById(notificationId: Long): Notification? {
        return notificationRepository.findById(notificationId).orElse(null)
    }

    @Transactional(readOnly = true)
    fun getNotificationsByUserId(userId: Long): List<Notification> {
        return notificationRepository.findByUserId(userId)
    }

    @Transactional
    fun updateNotification(notificationRequest: NotificationRequest) {
        val notification = notificationRepository.findById(notificationRequest.notificationId)
        if (notification.isPresent) {
            notification.get().apply {
                userId = notificationRequest.userId
                notificationType = notificationRequest.notificationType
                identifier = notificationRequest.identifier
                status = notificationRequest.status
                createdDate = notificationRequest.createdDate
            }
        }
    }

    @Transactional
    fun deleteNotification(notificationId: Long) {
        notificationRepository.deleteById(notificationId)
    }
}