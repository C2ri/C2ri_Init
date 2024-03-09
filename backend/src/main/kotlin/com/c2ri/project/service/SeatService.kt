package com.c2ri.project.service

import com.c2ri.project.domain.Seat
import com.c2ri.project.dto.test.request.SeatRequest
import com.c2ri.project.repository.SeatRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SeatService(private val seatRepository: SeatRepository) {

    fun saveSeat(seatRequest: SeatRequest) {
        val seat = Seat(
                vehicleId = seatRequest.vehicleId,
                routeId = seatRequest.routeId,
                seatNumber = seatRequest.seatNumber,
                status = seatRequest.status,
                modifiedDate = LocalDateTime.now()
        )
        seatRepository.save(seat)
    }

    fun getAllSeats(): List<Seat> {
        return seatRepository.findAll()
    }

    fun getSeatById(seatId: Long): Seat? {
        return seatRepository.findById(seatId).orElse(null)
    }

    fun updateSeat(seatId: Long, seatRequest: SeatRequest) {
        val seat = seatRepository.findById(seatId)
        if (seat.isPresent) {
            seat.get().apply {
                vehicleId = seatRequest.vehicleId
                routeId = seatRequest.routeId
                seatNumber = seatRequest.seatNumber
                status = seatRequest.status
                modifiedDate = LocalDateTime.now()
            }
        }
    }

    fun deleteSeat(seatId: Long) {
        seatRepository.deleteById(seatId)
    }
}