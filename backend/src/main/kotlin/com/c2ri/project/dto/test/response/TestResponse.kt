package com.c2ri.project.dto.test.response

import com.c2ri.project.domain.test.Test

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