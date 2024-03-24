package com.c2ri.project.dto

import com.c2ri.project.domain.Route
import java.time.LocalDateTime

data class RouteRequest(
        val routeId: Long,
        val departureLocation: String,
        val arrivalLocation: String,
        val departureTime: Int,
        val arrivalTime: Int,
        val estimatedTime: Int,
        val createdDate: LocalDateTime,
        val modifiedDate: LocalDateTime,
        val status: String
) {
    fun toDomain(): Route {
        return Route(
                routeId = this.routeId,
                departureLocation = this.departureLocation,
                arrivalLocation = this.arrivalLocation,
                departureTime = this.departureTime,
                arrivalTime = this.arrivalTime,
                estimatedTime = this.estimatedTime,
                status = this.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
    }

    fun updateDomain(route: Route): Route {
        return route.copy(
                routeId = this.routeId,
                departureLocation = this.departureLocation,
                arrivalLocation = this.arrivalLocation,
                departureTime = this.departureTime,
                arrivalTime = this.arrivalTime,
                estimatedTime = this.estimatedTime,
                status = this.status,
                modifiedDate = LocalDateTime.now()
        )
    }
}