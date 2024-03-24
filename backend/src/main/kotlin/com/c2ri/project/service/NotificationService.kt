package com.c2ri.project.service

import com.c2ri.project.domain.Notification
import com.c2ri.project.dto.NotificationRequest
import com.c2ri.project.repository.NotificationRepository
import com.c2ri.project.util.CustomSecurityContextHolder
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NotificationService(private val notificationRepository: NotificationRepository) {

    private val logger = LoggerFactory.getLogger(NotificationService::class.java)

    fun saveNotification(notificationRequest: NotificationRequest) {
        notificationRepository.save(notificationRequest.toDomain())
    }

    @Transactional(readOnly = true)
    fun getNotificationById(notificationId: Long): Notification? {
        return notificationRepository.findById(notificationId).orElse(null)
    }

    @Transactional(readOnly = true)
    fun getNotificationsByUserId(userId: Long): List<Notification> {
        return notificationRepository.findByUserId(userId)
    }

    fun updateNotification(notificationRequest: NotificationRequest) {
        val userId = CustomSecurityContextHolder.getSessionUserId() ?: throw IllegalArgumentException("User ID cannot be null")
        logger.info("Updating notification: $notificationRequest for user: $userId")
        val notification = notificationRepository.findByNotificationIdAndUserId(notificationRequest.notificationId, userId)
        if (notification.isPresent) {
            notificationRepository.save(notificationRequest.updateDomain(notification.get()))
        } else {
            throw IllegalArgumentException("Notification not found or user not authorized")
        }
    }

    fun deleteNotification(notificationId: Long) {
        val userId = CustomSecurityContextHolder.getSessionUserId() ?: throw IllegalArgumentException("User ID cannot be null")
        logger.info("Deleting notification with id : $notificationId for user: $userId")
        val notification = notificationRepository.findByNotificationIdAndUserId(notificationId, userId)
        if (notification.isPresent) {
            notificationRepository.delete(notification.get())
        }
    }
}