package com.c2ri.project.service

import com.c2ri.project.domain.Vehicle
import com.c2ri.project.repository.VehicleRepository
import com.c2ri.project.dto.test.request.VehicleRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class VehicleService(private val vehicleRepository: VehicleRepository) {

    fun saveVehicle(vehicleRequest: VehicleRequest) {
        val vehicle = Vehicle(
                routeId = vehicleRequest.routeId,
                seatNumber = vehicleRequest.seatNumber,
                manufacturingCompany = vehicleRequest.manufacturingCompany,
                vehicleNumber = vehicleRequest.vehicleNumber,
                vehicleType = vehicleRequest.vehicleType,
                status = vehicleRequest.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
        vehicleRepository.save(vehicle)
    }

    fun getAllVehicles(): List<Vehicle> {
        return vehicleRepository.findAll()
    }

    fun getVehicleById(vehicleId: Long): Vehicle? {
        return vehicleRepository.findById(vehicleId).orElse(null)
    }

    fun updateVehicle(vehicleRequest: VehicleRequest) {
        val vehicle = vehicleRepository.findById(vehicleRequest.vehicleId)
        if (vehicle.isPresent) {
            vehicle.get().apply {
                routeId = vehicleRequest.routeId
                seatNumber = vehicleRequest.seatNumber
                manufacturingCompany = vehicleRequest.manufacturingCompany
                vehicleNumber = vehicleRequest.vehicleNumber
                vehicleType = vehicleRequest.vehicleType
                status = vehicleRequest.status
                modifiedDate = LocalDateTime.now()
            }
        }
    }

    fun deleteVehicle(vehicleId: Long) {
        vehicleRepository.deleteById(vehicleId)
    }
}