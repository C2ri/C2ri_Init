package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "questions")
data class Question(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "questionId")
        val questionId: Long? = null,

        @Column(name = "userId")
        val userId: Long,

        @Column(name = "title")
        var title: String,

        @Column(name = "content")
        var content: String,

        @Column(name = "createdDate")
        val createdDate: LocalDateTime? = null,

        @Column(name = "modifiedDate")
        var modifiedDate: LocalDateTime? = null,

        @Column(name = "status")
        var status: String
)