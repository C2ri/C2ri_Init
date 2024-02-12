package com.c2ri.project.controller

import com.c2ri.project.domain.test.Test
import com.c2ri.project.dto.test.request.TestRequest
import com.c2ri.project.service.test.TestService
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
class TestController (
        private val testService: TestService
){
    //@ApiOperation(value = "Get Mapping Test")
    @GetMapping("/test")
    fun testGetMapping(
    ): Optional<Test>{
        return testService.testGetMapping()
    }
}