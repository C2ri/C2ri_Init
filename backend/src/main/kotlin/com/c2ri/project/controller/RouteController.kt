package com.c2ri.project.controller

import com.c2ri.project.domain.Route
import com.c2ri.project.dto.RouteRequest
import com.c2ri.project.service.RouteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "노선 관리", description = "노선 관리 API")
@RestController
@RequestMapping("/route")
class RouteController(private val routeService: RouteService) {

    @Operation(summary = "새로운 노선 생성")
    @PostMapping
    fun saveRoute(@Parameter(description = "새로운 노선을 생성하기 위한 노선 상세 정보") @RequestBody routeRequest: RouteRequest): ResponseEntity<Void> {
        routeService.saveRoute(routeRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @Operation(summary = "모든 노선 가져오기")
    @GetMapping
    fun getAllRoutes(): ResponseEntity<List<Route>> {
        val routes = routeService.getAllRoutes()
        return ResponseEntity(routes, HttpStatus.OK)
    }

    @Operation(summary = "ID로 노선 가져오기")
    @PostMapping("/find")
    fun getRouteById(@Parameter(description = "가져올 노선의 ID") @RequestBody routeId: Long): ResponseEntity<Route> {
        val route = routeService.getRouteById(routeId)
        return route?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @Operation(summary = "노선 업데이트")
    @PutMapping
    fun updateRoute(@Parameter(description = "기존 노선을 업데이트하기 위한 노선 상세 정보") @RequestBody routeRequest: RouteRequest): ResponseEntity<Void> {
        routeService.updateRoute(routeRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @Operation(summary = "노선 삭제")
    @DeleteMapping
    fun deleteRoute(@Parameter(description = "삭제할 노선의 ID") @RequestBody routeId: Long): ResponseEntity<Void> {
        routeService.deleteRoute(routeId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}