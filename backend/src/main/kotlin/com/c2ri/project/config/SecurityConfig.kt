package com.c2ri.project.config

import com.c2ri.project.auth.JwtAuthenticationFilter
import com.c2ri.project.auth.OAuthLoginFailureHandler
import com.c2ri.project.auth.OAuthLoginSuccessHandler
import com.c2ri.project.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig (
        private val jwtAuthenticationFilter: JwtAuthenticationFilter,
        private val oauthUserService: UserService
){
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            /** Setting **/
            httpBasic { disable() }
            csrf { disable() }
            formLogin { disable() }
            /*
            formLogin {
                loginPage = "/login"
            }
            */
            sessionManagement { SessionCreationPolicy.STATELESS }
//            authorizeRequests {
//                authorize("/css/**", permitAll)
//                authorize("/swagger-ui/**", permitAll)
//                authorize("/swagger-resources/**", permitAll)
//                authorize("/v3/api-docs", permitAll)
//                authorize("/user/**", permitAll) //임시적용
//                authorize("/login/**", permitAll) //임시적용
//                //authorize("/user/**", hasAuthority("ROLE_USER"))
//            }
            authorizeHttpRequests {
                authorize(anyRequest, authenticated)
                authorize(anyRequest, permitAll)
            }
            /*
                개략적인 순서
                1) jwtAuthenticationFilter : JWT 토큰이 있다면 검증 -> 검증되지 않으면 2로 이동
                2) OAuth2AuthorizationRequestRedirectFilter : OAUTH2 로그인진행
                3) 기존 EMAIL 이 있다면 로그인
                4) 없다면 회원가입 진행 후 자동 로그인 진행
            */

            /** Filter **/
//            http.addFilterBefore(
//                    jwtAuthenticationFilter,
//                    OAuth2AuthorizationRequestRedirectFilter::class.java
//            )
            //OAuth2AuthorizationRequestRedirectFilter 세팅
            oauth2Login {
                //loginPage = "/login"
                authorizationEndpoint {
                    //baseUri = "/oauth2/authorize"
                    authorizationRequestRepository = HttpSessionOAuth2AuthorizationRequestRepository()
                }
                userInfoEndpoint {
                    userService = oauthUserService
                }
                authenticationSuccessHandler = OAuthLoginSuccessHandler()
                authenticationFailureHandler = OAuthLoginFailureHandler()
            }
        }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder()

}