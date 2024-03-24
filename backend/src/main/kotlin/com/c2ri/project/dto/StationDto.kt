import com.c2ri.project.domain.Station
import java.time.LocalDateTime

data class StationRequest(
        val stationId: Long,
        val routeId: Long,
        val sequence: Int,
        val stationName: String,
        val roadNameAddress: String,
        val x: String,
        val y: String,
        val createdDate: LocalDateTime,
        val modifiedDate: LocalDateTime,
        val status: String
) {
    fun toDomain(): Station {
        return Station(
                stationId = this.stationId,
                routeId = this.routeId,
                sequence = this.sequence,
                stationName = this.stationName,
                roadNameAddress = this.roadNameAddress,
                x = this.x,
                y = this.y,
                status = this.status,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        )
    }

    fun updateDomain(station: Station): Station {
        return station.copy(
                stationId = this.stationId,
                routeId = this.routeId,
                sequence = this.sequence,
                stationName = this.stationName,
                roadNameAddress = this.roadNameAddress,
                x = this.x,
                y = this.y,
                status = this.status,
                modifiedDate = LocalDateTime.now()
        )
    }
}