package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "answers")
data class Answer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val answerId: Long? = null,

        var questionId: Long,

        var userId: Long,

        var title: String,

        var content: String,

        val createdDate: LocalDateTime? = null,

        var modifiedDate: LocalDateTime? = null,

        var status: String
)