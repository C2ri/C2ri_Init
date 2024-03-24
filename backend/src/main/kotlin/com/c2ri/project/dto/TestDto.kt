package com.c2ri.project.dto

import com.c2ri.project.domain.test.Test

data class TestRequest (
        val id: Int,
        val content: String,
)

class TestResponse (
        val id: Int,
        val content: String,
) {
    companion object {
        fun of(test: Test): TestResponse {
            return TestResponse(
                    id = test.id,
                    content = test.content
            )
        }
    }
}