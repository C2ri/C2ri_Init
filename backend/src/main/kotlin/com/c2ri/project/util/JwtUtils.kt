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

    //@Value("\${jwt.expiration}")
    private var jwtExpiration: Int = 50000

    fun generateToken(userEmail: String): String {
        return Jwts.builder()
                .setSubject(userEmail.toString())
                .setIssuedAt(Date())
                .setExpiration(Date(Date().time + jwtExpiration * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact()
    }

    fun getUserEmailFromJwtToken(token: String): String {
        val claims: Claims = Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).body
        return claims.subject.toString()
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