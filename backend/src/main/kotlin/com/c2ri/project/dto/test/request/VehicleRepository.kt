package com.c2ri.project.dto.test.request

import com.c2ri.project.domain.Vehicle
import org.springframework.data.jpa.repository.JpaRepository

interface VehicleRepository : JpaRepository<Vehicle, Long>