package com.c2ri.project.service.auth

import com.c2ri.project.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class KakaoService (
        private val userRepository : UserRepository
){
}