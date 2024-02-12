package com.c2ri.project.controller

import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/test")
@RestController
class TestController {
    @ApiOperation(value = "Get Mapping Test")
    @GetMapping("")
    fun getTest(){
        return
    }
}