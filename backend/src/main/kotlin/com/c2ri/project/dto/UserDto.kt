package com.c2ri.project.dto

import com.c2ri.project.domain.User
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
) {
    fun toDomain(): User {
        return User(
                email = this.email,
                nickname = this.nickname,
                location = this.location,
                profileUrl = this.profileUrl,
                status = this.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
    }

    fun updateDomain(user: User): User {
        return user.copy(
                email = this.email,
                nickname = this.nickname,
                location = this.location,
                profileUrl = this.profileUrl,
                status = this.status,
                modifiedDate = LocalDateTime.now()
        )
    }
}
