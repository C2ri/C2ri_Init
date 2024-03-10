package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "userId")
        val userId: Long? = null,

        @Column(name = "oauthId")
        val oauthId: Long,

        @Column(name = "nickname")
        val nickname: String,

        @Column(name = "location")
        val location: String,

        @Column(name = "profileUrl")
        val profileUrl: String,

        @Column(name = "createdDate")
        val createdDate: LocalDateTime? = null,

        @Column(name = "modifiedDate")
        val modifiedDate: LocalDateTime? = null,

        @Column(name = "status")
        val status: String
)