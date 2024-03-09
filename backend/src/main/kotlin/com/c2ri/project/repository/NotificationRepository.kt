package com.c2ri.project.repository

import com.c2ri.project.domain.Notification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NotificationRepository : JpaRepository<Notification, Long> {
    // 특정 userId에 해당하는 모든 알림을 가져오는 메서드
    fun findByUserId(userId: Long): List<Notification>

    // 특정 notificationId에 해당하는 알림을 가져오는 메서드
    fun findByNotificationId(notificationId: Long): Notification?
}