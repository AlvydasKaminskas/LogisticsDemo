package eu.codeacademy.LogisticsDemo.converters;

import eu.codeacademy.LogisticsDemo.dto.TrailerDTO;
import eu.codeacademy.LogisticsDemo.entities.Driver;
import eu.codeacademy.LogisticsDemo.entities.Trailer;

import java.util.ArrayList;
import java.util.List;

public abstract class TrailerConverter {

    public static TrailerDTO toDTO(Trailer trailer) {
        TrailerDTO trailerDTO = new TrailerDTO();
        if (trailer != null) {
            trailerDTO.setId(trailer.getId());
            trailerDTO.setLicensePlateNumber(trailer.getLicensePlateNumber());
            trailerDTO.setTrailerType(trailer.getTrailerType());
            trailerDTO.setIsAvailable(trailer.getIsAvailable());
            trailerDTO.setDriverId(trailer.getAssignedDriver1().getId());
        }
        return trailerDTO;
    }

    public static Trailer toEntity(TrailerDTO trailerDTO) {
        Trailer trailer = new Trailer();
        if (trailerDTO != null) {
            trailer.setId(trailerDTO.getId());
            trailer.setLicensePlateNumber(trailerDTO.getLicensePlateNumber());
            trailer.setTrailerType(trailerDTO.getTrailerType());
            trailer.setIsAvailable(trailerDTO.getIsAvailable());
            if (trailerDTO.getDriverId() != null) {
                Driver driverEntity = new Driver();
                driverEntity.setId(trailerDTO.getDriverId());
                trailer.setAssignedDriver1(driverEntity);

            }
        }
        return trailer;
    }

    public static List<TrailerDTO> toDTOList(List<Trailer> trailers){
        List<TrailerDTO> trailerDTOList = null;
        if (trailers != null && !trailers.isEmpty()){
            trailerDTOList = new ArrayList<>();
            for (Trailer tr : trailers){
                trailerDTOList.add(toDTO(tr));
            }
        }
        return trailerDTOList;
    }


}
