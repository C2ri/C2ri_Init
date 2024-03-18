package com.c2ri.project.service

import com.c2ri.project.domain.User
import com.c2ri.project.dto.test.request.UserRequest
import com.c2ri.project.repository.UserRepository
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(
        private val userRepository: UserRepository
) : DefaultOAuth2UserService() {

    override fun loadUser(oAuth2UserRequest: OAuth2UserRequest): OAuth2User {
        val oAuth2User = super.loadUser(oAuth2UserRequest)
        val attributes = oAuth2User.attributes
        val authorities = mutableListOf(OAuth2UserAuthority(attributes))
        //val accessToken = oAuth2UserRequest.accessToken.toString() //TODO 현재 사용X
        //System.out.println("토큰 확인 : $accessToken")

        val email : String = when (oAuth2UserRequest.clientRegistration.registrationId) { //TODO enum을 사용해야하는지 고민 => 굳이?
            "kakao" -> {
                oAuth2User.attributes["kakao_account"].toString()
            }
            "naver" -> {
                oAuth2User.attributes["response"].toString()
            }
            "google" -> {
                oAuth2User.attributes["email"].toString()
            }
            else -> {
                throw UnsupportedOperationException("Unsupported OAuth2 provider")
            }
        }

        val user : User? = getUserByEmail(email)

        /** 회원가입 진행 **/
        if(user == null){
            println("회원가입 : $email") //TODO LOGGING 대체예정
        }

        /** 로그인 진행 **/
        println("유저조회 : $user") //TODO LOGGING 대체예정
        val authentication = UsernamePasswordAuthenticationToken(user, null, authorities) //TODO password 안쓰는 authentication으로 교체예정 (소셜로그인만 사용)
        SecurityContextHolder.getContext().authentication = authentication //세션저장
        println("SecurityContextHolder 저장값 조회 : " + SecurityContextHolder.getContext().authentication.toString()) //TODO LOGGING 대체예정

        return DefaultOAuth2User(authorities, attributes, "email")
    }

    fun loadUserByEmail(email: String): UserDetails {
        val user = userRepository.findByEmail(email)
        println("loadUserByEmail :" + user.toString())
        if (user == null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username("") // 사용자 ID를 문자열로 반환
                    // .password(user.password) // 비밀번호
                    // .roles(user.roles) // 사용자 역할
                    .build()
        }else{
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.email) // 사용자 ID를 문자열로 반환
                    // .password(user.password) // 비밀번호
                    // .roles(user.roles) // 사용자 역할
                    .build()
        }
    }

    fun saveUser(oAuth2UserRequest: UserRequest) {
        val user = User(
                email = oAuth2UserRequest.email,
                nickname = oAuth2UserRequest.nickname,
                location = oAuth2UserRequest.location,
                profileUrl = oAuth2UserRequest.profileUrl,
                status = oAuth2UserRequest.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
        userRepository.save(user)
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUserByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }
}