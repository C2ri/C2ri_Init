package com.c2ri.project.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "answers")
data class Answer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "answerId")
        val answerId: Long? = null,

        @Column(name = "questionId")
        var questionId: Long,

        @Column(name = "userId")
        var userId: Long,

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