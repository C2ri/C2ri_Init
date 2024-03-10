package com.c2ri.project.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtils {

    @Value("\${jwt.secret}")
    private lateinit var jwtSecret: String

    @Value("\${jwt.expiration}")
    private var jwtExpiration: Int = 0

    fun generateJwtToken(userId: Long): String {
        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(Date())
                .setExpiration(Date(Date().time + jwtExpiration * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact()
    }

    fun getUserIdFromJwtToken(token: String): Long {
        val claims: Claims = Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).body
        return claims.subject.toLong()
    }

    fun validateJwtToken(token: String): Boolean {
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token)
            return true
        } catch (e: Exception) {
            return false
        }
    }
}