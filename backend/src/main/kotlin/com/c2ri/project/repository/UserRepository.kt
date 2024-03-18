package com.c2ri.project.repository

import com.c2ri.project.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}