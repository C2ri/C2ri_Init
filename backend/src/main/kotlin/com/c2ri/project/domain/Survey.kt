package com.c2ri.project.domain

import jakarta.persistence.*

@Entity
@Table(name = "survey")
data class Survey(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val surveyId: Long? = null,

        var rating: Int,

        var content: String,

        var userId: Long
)