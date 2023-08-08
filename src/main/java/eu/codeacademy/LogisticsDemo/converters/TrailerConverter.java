package eu.codeacademy.LogisticsDemo.converters;

import eu.codeacademy.LogisticsDemo.dto.TrailerDTO;
import eu.codeacademy.LogisticsDemo.entities.Driver;
import eu.codeacademy.LogisticsDemo.entities.Trailer;

public abstract class TrailerConverter {

    public static TrailerDTO toDTO(Trailer trailer) {
        TrailerDTO trailerDTO = null;
        if (trailer != null) {
            trailerDTO.setId(trailer.getId());
            trailerDTO.setLicensePlateNumber(trailer.getLicensePlateNumber());
            trailerDTO.setTrailerType(trailer.getTrailerType());
            trailerDTO.setIsAvailable(trailer.getIsAvailable());
            trailerDTO.setDriverId(trailer.getAssignedDriver().getId());
        }
        return trailerDTO;
    }

    public static Trailer toEntity(TrailerDTO trailerDTO) {
        Trailer trailer = null;
        if (trailerDTO != null) {
            trailer.setId(trailerDTO.getId());
            trailer.setLicensePlateNumber(trailerDTO.getLicensePlateNumber());
            trailer.setTrailerType(trailerDTO.getTrailerType());
            trailer.setIsAvailable(trailerDTO.getIsAvailable());
            if (trailerDTO.getDriverId() != null) {
                Driver driverEntity = new Driver();
                driverEntity.setId(trailerDTO.getDriverId());
                trailer.setAssignedDriver(driverEntity);

            }
        }
        return trailer;
    }


}
