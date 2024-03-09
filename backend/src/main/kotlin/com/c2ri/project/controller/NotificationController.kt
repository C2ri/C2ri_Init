package com.c2ri.project.controller

import com.c2ri.project.domain.Notification
import com.c2ri.project.dto.test.request.NotificationRequest
import com.c2ri.project.service.NotificationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notification")
class NotificationController(private val notificationService: NotificationService) {

    @PostMapping
    fun saveNotification(@RequestBody notificationRequest: NotificationRequest): ResponseEntity<Void> {
        notificationService.saveNotification(notificationRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping("/{notificationId}")
    fun getNotificationById(@PathVariable notificationId: Long): ResponseEntity<Notification> {
        val notification = notificationService.getNotificationById(notificationId)
        return notification?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    //추후 Spring Security 내 유저ID 기준으로 검색
    @GetMapping("/user/{userId}")
    fun getNotificationsByUserId(@PathVariable userId: Long): ResponseEntity<List<Notification>> {
        val notifications = notificationService.getNotificationsByUserId(userId)
        return ResponseEntity(notifications, HttpStatus.OK)
    }

    @PutMapping("/{notificationId}")
    fun updateNotification(
            @PathVariable notificationId: Long,
            @RequestBody notificationRequest: NotificationRequest
    ): ResponseEntity<Void> {
        notificationService.updateNotification(notificationId, notificationRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/{notificationId}")
    fun deleteNotification(@PathVariable notificationId: Long): ResponseEntity<Void> {
        notificationService.deleteNotification(notificationId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}