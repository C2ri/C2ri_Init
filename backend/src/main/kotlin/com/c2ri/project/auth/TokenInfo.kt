package com.c2ri.project.auth

/*
 * @param grantType : 권한 인증 타입(ex.Bearer)
 * @accessToken     : 실제 확인 토큰값
 */
data class TokenInfo(
        val grantType: String,
        val accessToken: String,
)
