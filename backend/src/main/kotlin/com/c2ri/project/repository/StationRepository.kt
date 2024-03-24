package com.c2ri.project.repository

import com.c2ri.project.domain.Station
import org.springframework.data.jpa.repository.JpaRepository

interface StationRepository : JpaRepository<Station, Long>