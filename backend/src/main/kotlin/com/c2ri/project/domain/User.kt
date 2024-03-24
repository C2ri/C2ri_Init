package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val userId: Long? = null,

        val email: String,

        val nickname: String,

        val location: String,

        val profileUrl: String,

        val createdDate: LocalDateTime? = null,

        val modifiedDate: LocalDateTime? = null,

        val status: String
)