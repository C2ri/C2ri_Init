package com.c2ri.project.controller

import com.c2ri.project.domain.User
import com.c2ri.project.dto.UserRequest
import com.c2ri.project.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "사용자 관리", description = "사용자 관리 API")
@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @Operation(summary = "새로운 사용자 생성")
    @PostMapping
    fun saveUser(@Parameter(description = "새로운 사용자를 생성하기 위한 사용자 상세 정보") @RequestBody userRequest: UserRequest): ResponseEntity<Void> {
        userService.saveUser(userRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @Operation(summary = "모든 사용자 가져오기")
    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        val users = userService.getAllUsers()
        return ResponseEntity(users, HttpStatus.OK)
    }
}