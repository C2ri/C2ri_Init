package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "questions")
data class Question(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val questionId: Long? = null,

        val userId: Long,

        var title: String,
        var content: String,

        val createdDate: LocalDateTime? = null,

        var modifiedDate: LocalDateTime? = null,

        var status: String
)