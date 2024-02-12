package com.c2ri.project.domain.test

import org.springframework.data.jpa.repository.JpaRepository

interface TestRepository : JpaRepository<Test, Int>{
}