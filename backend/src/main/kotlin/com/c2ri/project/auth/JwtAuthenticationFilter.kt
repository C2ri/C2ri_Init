package com.c2ri.project.auth

import com.c2ri.project.service.UserService
import com.c2ri.project.util.CustomSecurityContextHolder
import com.c2ri.project.util.JwtUtils
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
        private val jwtUtils: JwtUtils, //TODO lateinit 을 안써도 되는지 확인
        private val userService: UserService
): OncePerRequestFilter() {

    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain
    ) {
        println("JwtAuthenticationFilter 동작")
        val jwtToken = extractJwtTokenFromRequest(request)
        if (jwtToken != null && jwtUtils.validateJwtToken(jwtToken)) {
            val userId = jwtUtils.getUserIdFromJwtToken(jwtToken) //TODO 일단 이 부분에서 DB 고민해야하는 것 : PK를 userId, email 중 무엇으로 해야하는가?
            println("JwtAuthenticationFilter 토큰조회 성공 : $jwtToken")
            //TODO 만약 유효하다면 DB를 재조회할 필요가 있을까?
            //val userDetails: UserDetails = userService.loadUserByEmail(userEmail)
            //val authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
            //authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
            //SecurityContextHolder.getContext().authentication = authentication
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