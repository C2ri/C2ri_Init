package com.c2ri.project.service

import com.c2ri.project.domain.Vehicle
import com.c2ri.project.dto.VehicleRequest
import com.c2ri.project.repository.VehicleRepository
import org.springframework.stereotype.Service

@Service
class VehicleService(private val vehicleRepository: VehicleRepository) {

    fun saveVehicle(vehicleRequest: VehicleRequest) {
        vehicleRepository.save(vehicleRequest.toDomain())
    }

    fun getAllVehicles(): List<Vehicle> {
        return vehicleRepository.findAll()
    }

    fun getVehicleById(vehicleId: Long): Vehicle? {
        return vehicleRepository.findById(vehicleId).orElse(null)
    }

    fun updateVehicle(vehicleRequest: VehicleRequest) {
        vehicleRepository.findById(vehicleRequest.vehicleId).ifPresent { vehicle ->
            vehicleRequest.updateDomain(vehicle)
        }
    }

    fun deleteVehicle(vehicleId: Long) {
        vehicleRepository.deleteById(vehicleId)
    }
}