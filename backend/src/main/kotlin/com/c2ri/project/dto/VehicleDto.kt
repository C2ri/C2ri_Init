package com.c2ri.project.dto

import com.c2ri.project.domain.Vehicle
import java.time.LocalDateTime

data class VehicleRequest(
        val vehicleId: Long,
        val routeId: Long,
        val seatNumber: Int,
        val manufacturingCompany: String,
        val vehicleNumber: Int,
        val vehicleType: String,
        val createdDate: LocalDateTime,
        val modifiedDate: LocalDateTime,
        val status: String
) {
    fun toDomain(): Vehicle {
        return Vehicle(
                routeId = this.routeId,
                seatNumber = this.seatNumber,
                manufacturingCompany = this.manufacturingCompany,
                vehicleNumber = this.vehicleNumber,
                vehicleType = this.vehicleType,
                status = this.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
    }

    fun updateDomain(vehicle: Vehicle): Vehicle {
        return vehicle.copy(
                routeId = this.routeId,
                seatNumber = this.seatNumber,
                manufacturingCompany = this.manufacturingCompany,
                vehicleNumber = this.vehicleNumber,
                vehicleType = this.vehicleType,
                status = this.status,
                modifiedDate = LocalDateTime.now()
        )
    }
}