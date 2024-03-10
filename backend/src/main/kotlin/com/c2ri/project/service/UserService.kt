package com.c2ri.project.service

import com.c2ri.project.domain.User
import com.c2ri.project.dto.test.request.UserRequest
import com.c2ri.project.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(private val userRepository: UserRepository) {

    fun saveUser(userRequest: UserRequest) {
        val user = User(
                oauthId = userRequest.oauthId,
                nickname = userRequest.nickname,
                location = userRequest.location,
                profileUrl = userRequest.profileUrl,
                status = userRequest.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
        userRepository.save(user)
    }

    fun getUserByOauthId(oauthId: Long): User? {
        return userRepository.findByOauthId(oauthId)
    }
}