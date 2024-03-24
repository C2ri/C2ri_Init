package com.c2ri.project.service

import com.c2ri.project.domain.Route
import com.c2ri.project.dto.RouteRequest
import com.c2ri.project.repository.RouteRepository
import org.springframework.stereotype.Service

@Service
class RouteService(private val routeRepository: RouteRepository) {

    fun saveRoute(routeRequest: RouteRequest) {
        routeRepository.save(routeRequest.toDomain())
    }

    fun getAllRoutes(): List<Route> {
        return routeRepository.findAll()
    }

    fun getRouteById(routeId: Long): Route? {
        return routeRepository.findById(routeId).orElse(null)
    }

    fun updateRoute(routeRequest: RouteRequest) {
        val route = routeRepository.findById(routeRequest.routeId)
        if (route.isPresent) {
            routeRepository.save(routeRequest.updateDomain(route.get()))
        }
    }

    fun deleteRoute(routeId: Long) {
        routeRepository.deleteById(routeId)
    }
}