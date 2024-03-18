package com.c2ri.project.auth

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler
import java.io.StringWriter

class OAuthLoginFailureHandler : SimpleUrlAuthenticationFailureHandler() {

    override fun onAuthenticationFailure(request: HttpServletRequest, response: HttpServletResponse, exception: AuthenticationException) {
        //TODO 소셜로그인 실패시 로깅
        // 로그인 실패 시 실행되는 로직을 여기에 구현합니다.
        val writer = StringWriter()
        writer.use {
            it.appendln("Request Method: ${request.method}")
            it.appendln("Request URI: ${request.requestURI}")
            it.appendln("Request URL: ${request.requestURL}")
            it.appendln("Protocol: ${request.protocol}")
            it.appendln("Remote Address: ${request.remoteAddr}")
            it.appendln("Headers:")
            val headers = request.headerNames
            while (headers.hasMoreElements()) {
                val headerName = headers.nextElement()
                it.appendln("\t$headerName: ${request.getHeader(headerName)}")
            }
            it.appendln("Parameters:")
            val params = request.parameterMap
            for ((key, value) in params) {
                it.appendln("\t$key: ${value.joinToString(", ")}")
            }
        }
        println("request : " + writer.toString())
        writer.close()
        val writer2 = StringWriter()
        writer2.use {
            it.appendln("Status Code: ${response.status}")
            it.appendln("Headers:")
            response.headerNames.forEach { headerName ->
                it.appendln("\t$headerName: ${response.getHeader(headerName)}")
            }
        }
        println("response : " + writer2.toString())
        println("exception : " + exception.toString())

        super.onAuthenticationFailure(request, response, exception)
    }
}