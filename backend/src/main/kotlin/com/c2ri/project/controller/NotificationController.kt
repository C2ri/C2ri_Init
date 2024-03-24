package com.c2ri.project.controller

import com.c2ri.project.domain.Notification
import com.c2ri.project.dto.NotificationRequest
import com.c2ri.project.service.NotificationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "알림 관리", description = "알림 관리 API")
@RestController
@RequestMapping("/notification")
class NotificationController(private val notificationService: NotificationService) {

    @Operation(summary = "새로운 알림 생성")
    @PostMapping
    fun saveNotification(@Parameter(description = "새로운 알림을 생성하기 위한 알림 상세 정보") @RequestBody notificationRequest: NotificationRequest): ResponseEntity<Void> {
        notificationService.saveNotification(notificationRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @Operation(summary = "ID로 알림 가져오기")
    @PostMapping("/find")
    fun getNotificationById(@Parameter(description = "가져올 알림의 ID") @RequestBody notificationId: Long): ResponseEntity<Notification> {
        val notification = notificationService.getNotificationById(notificationId)
        return notification?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @Operation(summary = "유저ID로 알림 가져오기")
    @PostMapping("/user")
    fun getNotificationsByUserId(@Parameter(description = "가져올 알림의 유저ID") @RequestBody userId: Long): ResponseEntity<List<Notification>> {
        val notifications = notificationService.getNotificationsByUserId(userId)
        return ResponseEntity(notifications, HttpStatus.OK)
    }

    @Operation(summary = "알림 업데이트")
    @PutMapping
    fun updateNotification(@Parameter(description = "기존 알림을 업데이트하기 위한 알림 상세 정보") @RequestBody notificationRequest: NotificationRequest): ResponseEntity<Void> {
        notificationService.updateNotification(notificationRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @Operation(summary = "알림 삭제")
    @DeleteMapping
    fun deleteNotification(@Parameter(description = "삭제할 알림의 ID") @RequestBody notificationId: Long): ResponseEntity<Void> {
        notificationService.deleteNotification(notificationId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}