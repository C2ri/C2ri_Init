package com.c2ri.project.controller

import com.c2ri.project.domain.Vehicle
import com.c2ri.project.dto.VehicleRequest
import com.c2ri.project.service.VehicleService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "차량 관리", description = "차량 관리 API")
@RestController
@RequestMapping("/vehicle")
class VehicleController(private val vehicleService: VehicleService) {

    @Operation(summary = "새로운 차량 생성")
    @PostMapping
    fun saveVehicle(@Parameter(description = "새로운 차량을 생성하기 위한 차량 상세 정보") @RequestBody vehicleRequest: VehicleRequest): ResponseEntity<Void> {
        vehicleService.saveVehicle(vehicleRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @Operation(summary = "모든 차량 가져오기")
    @GetMapping
    fun getAllVehicles(): ResponseEntity<List<Vehicle>> {
        val vehicles = vehicleService.getAllVehicles()
        return ResponseEntity(vehicles, HttpStatus.OK)
    }

    @Operation(summary = "ID로 차량 가져오기")
    @PostMapping("/find")
    fun getVehicleById(@Parameter(description = "가져올 차량의 ID") @RequestBody vehicleId: Long): ResponseEntity<Vehicle> {
        val vehicle = vehicleService.getVehicleById(vehicleId)
        return vehicle?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @Operation(summary = "차량 업데이트")
    @PutMapping
    fun updateVehicle(@Parameter(description = "기존 차량을 업데이트하기 위한 차량 상세 정보") @RequestBody vehicleRequest: VehicleRequest): ResponseEntity<Void> {
        vehicleService.updateVehicle(vehicleRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @Operation(summary = "차량 삭제")
    @DeleteMapping
    fun deleteVehicle(@Parameter(description = "삭제할 차량의 ID") @RequestBody vehicleId: Long): ResponseEntity<Void> {
        vehicleService.deleteVehicle(vehicleId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}