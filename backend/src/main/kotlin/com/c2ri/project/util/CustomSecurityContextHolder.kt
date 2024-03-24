package com.c2ri.project.util

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.core.user.OAuth2User

object CustomSecurityContextHolder {

    private val jwtUtils = JwtUtils() // Add this line

    private fun setAuthentication(authentication: UsernamePasswordAuthenticationToken) {
        SecurityContextHolder.getContext().authentication = authentication
    }

    fun getAuthentication(): Authentication {
        return SecurityContextHolder.getContext().authentication
    }

    fun convertUserIdToJwtToken(userId: Long, authorities: Collection<GrantedAuthority>) {
        val jwtToken = jwtUtils.generateToken(userId) // Generate JWT token from user ID
        val authentication = UsernamePasswordAuthenticationToken(userId, jwtToken, authorities)
        setAuthentication(authentication)
    }

    //TODO 추후에 FRONT 내 토큰으로 검증예정
    fun convertJwtTokenToUserId(jwtToken: String): Long {
        return jwtUtils.getUserIdFromJwtToken(jwtToken)
    }

    //TODO 임시로 세션내 토큰 사용
    fun convertSessionJwtTokenToUserId(): Long? {
        println("SecurityContextHolder.getContext().authentication : ${SecurityContextHolder.getContext()}")
        val authentication = getAuthentication()
        return if (authentication is UsernamePasswordAuthenticationToken) {
            jwtUtils.getUserIdFromJwtToken(authentication.principal as String)
        } else {
            null
        }
    }

    fun getSessionUserId(): Long? {
        val authentication = SecurityContextHolder.getContext().authentication
        val oAuth2User = authentication.principal as OAuth2User
        return oAuth2User.attributes["userId"] as Long?
    }

    private fun getJwtToken(): String? {
        val authentication = getAuthentication()
        return if (authentication is UsernamePasswordAuthenticationToken) {
            authentication.principal as String
        } else {
            null
        }
    }
}