package com.c2ri.project.service

import com.c2ri.project.domain.Station
import com.c2ri.project.dto.test.request.StationRequest
import com.c2ri.project.repository.StationRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class StationService(private val stationRepository: StationRepository) {

    fun saveStation(stationRequest: StationRequest) {
        val station = Station(
                routeId = stationRequest.routeId,
                sequence = stationRequest.sequence,
                stationName = stationRequest.stationName,
                roadNameAddress = stationRequest.roadNameAddress,
                x = stationRequest.x,
                y = stationRequest.y,
                status = stationRequest.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
        stationRepository.save(station)
    }

    fun getAllStations(): List<Station> {
        return stationRepository.findAll()
    }

    fun getStationById(stationId: Long): Station? {
        return stationRepository.findById(stationId).orElse(null)
    }

    fun updateStation(stationRequest: StationRequest) {
        val station = stationRepository.findById(stationRequest.stationId)
        if (station.isPresent) {
            station.get().apply {
                routeId = stationRequest.routeId
                sequence = stationRequest.sequence
                stationName = stationRequest.stationName
                roadNameAddress = stationRequest.roadNameAddress
                x = stationRequest.x
                y = stationRequest.y
                status = stationRequest.status
                modifiedDate = LocalDateTime.now()
            }
        }
    }

    fun deleteStation(stationId: Long) {
        stationRepository.deleteById(stationId)
    }
}