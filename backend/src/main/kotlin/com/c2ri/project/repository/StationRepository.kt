package com.c2ri.project.repository

import com.c2ri.project.domain.Station
import com.c2ri.project.dto.test.request.StationRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

interface StationRepository : JpaRepository<Station, Long>