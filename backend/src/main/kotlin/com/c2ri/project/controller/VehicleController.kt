package com.c2ri.project.controller

import com.c2ri.project.domain.Vehicle
import com.c2ri.project.dto.test.request.VehicleRequest
import com.c2ri.project.service.VehicleService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/vehicle")
class VehicleController(private val vehicleService: VehicleService) {

    @PostMapping
    fun saveVehicle(@RequestBody vehicleRequest: VehicleRequest): ResponseEntity<Void> {
        vehicleService.saveVehicle(vehicleRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllVehicles(): ResponseEntity<List<Vehicle>> {
        val vehicles = vehicleService.getAllVehicles()
        return ResponseEntity(vehicles, HttpStatus.OK)
    }

    @GetMapping("/{vehicleId}")
    fun getVehicleById(@PathVariable vehicleId: Long): ResponseEntity<Vehicle> {
        val vehicle = vehicleService.getVehicleById(vehicleId)
        return vehicle?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping("/{vehicleId}")
    fun updateVehicle(
            @PathVariable vehicleId: Long,
            @RequestBody vehicleRequest: VehicleRequest
    ): ResponseEntity<Void> {
        vehicleService.updateVehicle(vehicleId, vehicleRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/{vehicleId}")
    fun deleteVehicle(@PathVariable vehicleId: Long): ResponseEntity<Void> {
        vehicleService.deleteVehicle(vehicleId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}