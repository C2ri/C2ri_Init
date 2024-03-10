package com.c2ri.project.controller

import com.c2ri.project.domain.Route
import com.c2ri.project.dto.test.request.RouteRequest
import com.c2ri.project.service.RouteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/route")
class RouteController(private val routeService: RouteService) {

    @PostMapping
    fun saveRoute(@RequestBody routeRequest: RouteRequest): ResponseEntity<Void> {
        routeService.saveRoute(routeRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllRoutes(): ResponseEntity<List<Route>> {
        val routes = routeService.getAllRoutes()
        return ResponseEntity(routes, HttpStatus.OK)
    }

    @PostMapping("/find")
    fun getRouteById(@RequestBody routeId: Long): ResponseEntity<Route> {
        val route = routeService.getRouteById(routeId)
        return route?.let { ResponseEntity(it, HttpStatus.OK) }
                ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping
    fun updateRoute(@RequestBody routeRequest: RouteRequest): ResponseEntity<Void> {
        routeService.updateRoute(routeRequest)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping
    fun deleteRoute(@RequestBody routeId: Long): ResponseEntity<Void> {
        routeService.deleteRoute(routeId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}