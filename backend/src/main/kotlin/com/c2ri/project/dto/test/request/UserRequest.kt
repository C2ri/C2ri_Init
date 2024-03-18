package com.c2ri.project.dto.test.request

import java.time.LocalDateTime

data class UserRequest (
    val userId: Long? = null,
    val email: String,
    val nickname: String,
    val location: String,
    val profileUrl: String,
    val createdDate: LocalDateTime? = null,
    val modifiedDate: LocalDateTime? = null,
    val status: String
)