package com.c2ri.project.repository

import com.c2ri.project.domain.Survey
import org.springframework.data.jpa.repository.JpaRepository

interface SurveyRepository : JpaRepository<Survey, Long>