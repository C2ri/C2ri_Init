package com.c2ri.project.service

import com.c2ri.project.domain.Seat
import com.c2ri.project.dto.SeatRequest
import com.c2ri.project.repository.SeatRepository
import org.springframework.stereotype.Service

@Service
class SeatService(private val seatRepository: SeatRepository) {

    fun saveSeat(seatRequest: SeatRequest) {
        seatRepository.save(seatRequest.toDomain())
    }

    fun getAllSeats(): List<Seat> {
        return seatRepository.findAll()
    }

    fun getSeatById(seatId: Long): Seat? {
        return seatRepository.findById(seatId).orElse(null)
    }

    fun updateSeat(seatRequest: SeatRequest) {
        val seat = seatRepository.findById(seatRequest.seatId)
        if (seat.isPresent) {
            seatRepository.save(seatRequest.updateDomain(seat.get()))
        }
    }

    fun deleteSeat(seatId: Long) {
        seatRepository.deleteById(seatId)
    }
}