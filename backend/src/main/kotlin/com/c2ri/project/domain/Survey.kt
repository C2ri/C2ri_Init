package com.c2ri.project.domain

import jakarta.persistence.*

@Entity
@Table(name = "survey")
data class Survey(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "surveyId")
        val surveyId: Long? = null,

        @Column(name = "rating")
        var rating: Int,

        @Column(name = "content")
        var content: String,

        @Column(name = "userId")
        var userId: Long
)