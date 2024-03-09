package com.c2ri.project.repository

import com.c2ri.project.domain.Route
import org.springframework.data.jpa.repository.JpaRepository

interface RouteRepository : JpaRepository<Route, Long>