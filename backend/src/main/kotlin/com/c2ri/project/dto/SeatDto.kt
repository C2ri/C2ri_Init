package com.c2ri.project.dto

import com.c2ri.project.domain.Seat
import java.time.LocalDateTime

data class SeatRequest(
        val seatId: Long,
        val vehicleId: Long,
        val routeId: Long,
        val seatNumber: Int,
        val modifiedDate: LocalDateTime,
        val status: String
) {
    fun toDomain(): Seat {
        return Seat(
                seatId = this.seatId,
                vehicleId = this.vehicleId,
                routeId = this.routeId,
                seatNumber = this.seatNumber,
                status = this.status,
                modifiedDate = LocalDateTime.now()
        )
    }

    fun updateDomain(seat: Seat): Seat {
        return seat.copy(
                seatId = this.seatId,
                vehicleId = this.vehicleId,
                routeId = this.routeId,
                seatNumber = this.seatNumber,
                status = this.status,
                modifiedDate = LocalDateTime.now()
        )
    }
}