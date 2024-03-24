package com.c2ri.project.service.test

import com.c2ri.project.domain.test.Test
import com.c2ri.project.domain.test.TestRepository
import com.c2ri.project.util.fail
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class TestService (
        private val testRepository: TestRepository
){
    @Transactional(readOnly = true)
    fun testGetMapping(
    ): Optional<Test> {
        val test = testRepository.findById(1) ?: fail() //TODO 추후 에러별 세부정의 필요
        return test
    }
}