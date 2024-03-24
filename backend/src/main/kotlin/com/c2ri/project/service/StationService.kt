package com.c2ri.project.service

import StationRequest
import com.c2ri.project.domain.Station
import com.c2ri.project.repository.StationRepository
import org.springframework.stereotype.Service

@Service
class StationService(private val stationRepository: StationRepository) {

    fun saveStation(stationRequest: StationRequest) {
        stationRepository.save(stationRequest.toDomain())
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
            stationRepository.save(stationRequest.updateDomain(station.get()))
        }
    }

    fun deleteStation(stationId: Long) {
        stationRepository.deleteById(stationId)
    }
}