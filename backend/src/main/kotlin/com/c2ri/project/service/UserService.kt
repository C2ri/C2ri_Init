package com.c2ri.project.service

import com.c2ri.project.domain.User
import com.c2ri.project.dto.UserRequest
import com.c2ri.project.repository.UserRepository
import com.c2ri.project.util.CustomSecurityContextHolder
import org.slf4j.LoggerFactory
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository
) : DefaultOAuth2UserService() {
    private val logger = LoggerFactory.getLogger(UserService::class.java)
    override fun loadUser(oAuth2UserRequest: OAuth2UserRequest): OAuth2User {
        val oAuth2User = super.loadUser(oAuth2UserRequest)
        val mutableAttributes = HashMap(oAuth2User.attributes) //불변객체 attribute 수정
        val authorities = mutableListOf(OAuth2UserAuthority(mutableAttributes))
        logger.info("attributes : $mutableAttributes")

        val email = getEmail(oAuth2UserRequest, oAuth2User)
        val user = userRepository.findByEmail(email)

        user?.userId?.let {
            logger.info("Converting user id to JWT token ${user.userId}, $it")
            mutableAttributes["userId"] = it //attribute 내 userId 추가 => SecurityContextHolder 내 Authentication 저장
            //TODO 추후에 토큰을 저장 : 위처럼 하는 이유?? 필터들을 거치면서 SecurityContextHolder 내 Authentication이 원본으로 변경됨
            //CustomSecurityContextHolder.convertUserIdToJwtToken(it, authorities)
        }

        return DefaultOAuth2User(authorities, mutableAttributes, "email")
    }

    private fun getEmail(oAuth2UserRequest: OAuth2UserRequest, oAuth2User: OAuth2User): String {
        return when (oAuth2UserRequest.clientRegistration.registrationId) {
            "kakao" -> oAuth2User.attributes["kakao_account"].toString()
            "naver" -> oAuth2User.attributes["response"].toString()
            "google" -> oAuth2User.attributes["email"].toString()
            else -> throw UnsupportedOperationException("Unsupported OAuth2 provider")
        }
    }

    fun saveUser(userRequest: UserRequest) {
        userRepository.save(userRequest.toDomain())
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }
}