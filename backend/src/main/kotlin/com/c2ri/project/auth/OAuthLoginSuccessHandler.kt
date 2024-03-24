package com.c2ri.project.auth

import com.c2ri.project.util.CustomSecurityContextHolder
import com.c2ri.project.util.JwtUtils
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component

@Component
class OAuthLoginSuccessHandler : SimpleUrlAuthenticationSuccessHandler() {
    override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {

        //소설로그인 성공 로그 적재
        val oauth2User = authentication.principal as OAuth2User
        println("소셜로그인 성공 : $oauth2User")
        println("onAuthenticationSuccess.authentication : ${CustomSecurityContextHolder.getAuthentication()}")
        //TODO JWT토큰 부여 부분만 추가할지 고민 중 => 그러나 서비스와 로직이 겹치기에 로깅만 하는게 좋아보임
//        when {
//            authentication.principal is OAuth2User -> {
//                val oauth2User = authentication.principal as OAuth2User
//                System.out.println("핸들러 : " + oauth2User.toString() + "\n뭔데 : " + authentication.toString() )
//                val provider = oauth2User.attributes["sub"]?.toString()
//                val token = authentication as? OAuth2AuthenticationToken //형변환
//                val email : String
//                when (provider) {
//                    "google" -> {
//                        // Google OAuth 로그인 성공 시 실행되는 로직
//                        if (token != null) {
//                            email = token.principal.attributes["email"].toString()
//                        }else{
//                            fail() //TODO 에러처리 세분화 예정
//                        }
//                    }
//                    "kakao" -> {
//                        // Kakao OAuth 로그인 성공 시 실행되는 로직
//                        if (token != null) {
//                            //TODO 이건 코드 개선예정
//                            email = ((token.principal?.attributes?.get("kakao_account") as? Map<String, *>?)?.get("email")).toString()
//                        }else{
//                            fail() //TODO 에러처리 세분화 예정
//                        }
//                    }
//                    "naver" -> {
//                        // Naver OAuth 로그인 성공 시 실행되는 로직
//                        if (token != null) {
//                            email = ((token.principal?.attributes?.get("response") as? Map<String, *>?)?.get("email")).toString()
//                        }else{
//                            fail() //TODO 에러처리 세분화 예정
//                        }
//                    }
//                    else -> {
//                        // 처리하지 않는 OAuth 제공자가 있을 경우에 대한 로직
//                        fail()
//                    }
//                }
//
//                val user : UserDetails = userDetailsServiceImpl.loadUserByEmail(email)
//                // 현재 사용자의 컨텍스트에 사용자 정보를 저장
//                if (user.username == "") { //회원이 아닌 경우
//                    //회원가입
//                    //userService.saveUser(user) //TODO 현재 타입이 UserDetails 인데 User 타입이 호환되는지 확인 => 안됨 username 등 일치시키기
//                }else{
//                    //TODO authorities 정의가 필요한지 확인
//                    authentication.details = WebAuthenticationDetailsSource().buildDetails(request) //JwtAuthenticationFilter 저장부와 똑같이 기록
//                    SecurityContextHolder.getContext().authentication = authentication
//                }
//
//
//                //Token 발급
//                val accessToken: String = jwtUtils.generateToken(oauth2User.attributes["userId"]) // JWT 토큰 생성
//                response.contentType = "application/json"
//                response.characterEncoding = "UTF-8"
//                response.writer.write(
//                        "{\"token\":\"$accessToken\"}" // 토큰을 JSON 형식으로 응답에 포함
//                )
//            }
//            else -> {
//                fail()
//            }
//        }
    }
}