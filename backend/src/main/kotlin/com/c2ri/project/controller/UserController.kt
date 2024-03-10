package com.c2ri.project.controller

import com.c2ri.project.domain.User
import com.c2ri.project.dto.test.request.UserRequest
import com.c2ri.project.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @PostMapping
    fun saveUser(@RequestBody userRequest: UserRequest): ResponseEntity<Void> {
        userService.saveUser(userRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PostMapping("/auth")
    fun getUserByOauthId(@RequestBody oauthId: Long): ResponseEntity<User> {
        val user = userService.getUserByOauthId(oauthId)
        return user?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }
}