package com.c2ri.project.config

import com.c2ri.project.auth.JwtAuthenticationFilter
import com.c2ri.project.auth.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig (
        private val jwtAuthenticationFilter: JwtAuthenticationFilter
){
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            /** Setting **/
            httpBasic { disable() }
            csrf { disable() }
            formLogin { disable() }
            sessionManagement { SessionCreationPolicy.STATELESS }
            authorizeRequests {
                authorize("/css/**", permitAll)
                authorize("/swagger-ui/**", permitAll)
                authorize("/swagger-resources/**", permitAll)
                authorize("/v3/api-docs", permitAll)
                authorize("/user/**", permitAll) //임시적용
                //authorize("/user/**", hasAuthority("ROLE_USER"))
            }
            /** Filter **/
            http.addFilterBefore(
                    jwtAuthenticationFilter,
                    UsernamePasswordAuthenticationFilter::class.java
            )
            /*
            formLogin {
                loginPage = "/log-in"
            }
            */
        }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder()
}