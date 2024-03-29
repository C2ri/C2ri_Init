package com.c2ri.project.repository

import com.c2ri.project.domain.Vehicle
import org.springframework.data.jpa.repository.JpaRepository

interface VehicleRepository : JpaRepository<Vehicle, Long>