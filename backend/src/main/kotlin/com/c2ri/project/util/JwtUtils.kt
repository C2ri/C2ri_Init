package com.c2ri.project.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.spec.SecretKeySpec
import java.nio.charset.StandardCharsets

@Component
class JwtUtils {

    //@Value("\${jwt.secret}")
    private var jwtSecret: String = "DadFufN4Oui8Bfv3ScFj6R9fyJ9hD45E6AGFsXgFsRhT4YSdSb" //TODO 나중에 바꾸기

    //@Value("\${jwt.expiration}")
    private var jwtExpiration: Int = 50000

    fun generateToken(userId: Any?): String {
        val key = SecretKeySpec(jwtSecret.toByteArray(StandardCharsets.UTF_8), SignatureAlgorithm.HS512.jcaName)
        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(Date())
                .setExpiration(Date(Date().time + jwtExpiration * 1000))
                .signWith(key)
                .compact()
    }

    fun getUserIdFromJwtToken(token: String): Long {
        val key = SecretKeySpec(jwtSecret.toByteArray(StandardCharsets.UTF_8), SignatureAlgorithm.HS512.jcaName)
        val claims: Claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).body
        return claims.subject.toLong()
    }

    fun validateJwtToken(token: String): Boolean {
        try {
            val key = SecretKeySpec(jwtSecret.toByteArray(StandardCharsets.UTF_8), SignatureAlgorithm.HS512.jcaName)
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
            return true
        } catch (e: Exception) {
            return false
        }
    }
}