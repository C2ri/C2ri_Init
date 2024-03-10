package com.c2ri.project.service

import com.c2ri.project.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        throw UsernameNotFoundException("Method not supported. Use loadUserById() instead.")
    }

    fun loadUserById(userId: Long): UserDetails {
        val user = userRepository.findById(userId)
                .orElseThrow { UsernameNotFoundException("User not found with id: $userId") }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.userId.toString()) // 사용자 ID를 문자열로 반환
               // .password(user.password) // 비밀번호
               // .roles(user.roles) // 사용자 역할
                .build()
    }
}