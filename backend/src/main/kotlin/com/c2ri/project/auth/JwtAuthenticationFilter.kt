package com.c2ri.project.auth

import com.c2ri.project.service.UserDetailsServiceImpl
import com.c2ri.project.util.JwtUtils
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import org.springframework.web.filter.GenericFilterBean
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter : OncePerRequestFilter() {

    @Autowired
    private lateinit var jwtUtils: JwtUtils

    @Autowired
    private lateinit var userDetailsServiceImpl: UserDetailsServiceImpl

    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain
    ) {
        val jwtToken = extractJwtTokenFromRequest(request)
        if (jwtToken != null && jwtUtils.validateJwtToken(jwtToken)) {
            val userId = jwtUtils.getUserIdFromJwtToken(jwtToken)
            val userDetails: UserDetails = userDetailsServiceImpl.loadUserById(userId)
            val authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
            authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }

    private fun extractJwtTokenFromRequest(request: HttpServletRequest): String? {
        val headerAuth = request.getHeader("Authorization")
        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7)
        }
        return null
    }
}