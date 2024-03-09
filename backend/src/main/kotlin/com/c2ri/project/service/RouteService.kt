package com.c2ri.project.service

import com.c2ri.project.domain.Route
import com.c2ri.project.dto.test.request.RouteRequest
import com.c2ri.project.repository.RouteRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class RouteService(private val routeRepository: RouteRepository) {

    fun saveRoute(routeRequest: RouteRequest) {
        val route = Route(
                departureLocation = routeRequest.departureLocation,
                arrivalLocation = routeRequest.arrivalLocation,
                departureTime = routeRequest.departureTime,
                arrivalTime = routeRequest.arrivalTime,
                estimatedTime = routeRequest.estimatedTime,
                status = routeRequest.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
        routeRepository.save(route)
    }

    fun getAllRoutes(): List<Route> {
        return routeRepository.findAll()
    }

    fun getRouteById(routeId: Long): Route? {
        return routeRepository.findById(routeId).orElse(null)
    }

    fun updateRoute(routeId: Long, routeRequest: RouteRequest) {
        val route = routeRepository.findById(routeId)
        if (route.isPresent) {
            route.get().apply {
                departureLocation = routeRequest.departureLocation
                arrivalLocation = routeRequest.arrivalLocation
                departureTime = routeRequest.departureTime
                arrivalTime = routeRequest.arrivalTime
                estimatedTime = routeRequest.estimatedTime
                status = routeRequest.status
                modifiedDate = LocalDateTime.now()
            }
        }
    }

    fun deleteRoute(routeId: Long) {
        routeRepository.deleteById(routeId)
    }
}