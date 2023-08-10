package eu.codeacademy.LogisticsDemo.services;

import eu.codeacademy.LogisticsDemo.converters.TrailerConverter;
import eu.codeacademy.LogisticsDemo.dto.TrailerDTO;
import eu.codeacademy.LogisticsDemo.entities.Driver;
import eu.codeacademy.LogisticsDemo.entities.Trailer;
import eu.codeacademy.LogisticsDemo.repositories.DriverRepository;
import eu.codeacademy.LogisticsDemo.repositories.TrailerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrailerService {

    private TrailerRepository trailerRepository;
    private DriverRepository driverRepository;
    private final String trailerExceptionTxt = "Trailer not found with id: ";
    private final String DriverExceptionTxt = "Driver not found with id: ";

    public List<TrailerDTO> getAllTrailerDTO() {
        return TrailerConverter.toDTOList(trailerRepository.findAll());
    }

    public TrailerDTO getTrailerDTOById(Long id) {
        if (trailerRepository.findById(id) == null) {
            throw new NoSuchElementException(trailerExceptionTxt + id);
        } else {
            return TrailerConverter.toDTO(trailerRepository.findById(id).get());
        }
    }

    public TrailerDTO createTrailer(TrailerDTO trailerDTO) {
        trailerRepository.save(TrailerConverter.toEntity(trailerDTO));
        return trailerDTO;
    }

    public TrailerDTO updateTrailer(TrailerDTO trailerDTO) {
        Trailer trailerToUpdate = trailerRepository.findById(trailerDTO.getId()).get();
        if (trailerDTO.getLicensePlateNumber() != null) {
            trailerToUpdate.setLicensePlateNumber(trailerDTO.getLicensePlateNumber());
        }
        if (trailerDTO.getTrailerType() != null) {
            trailerToUpdate.setTrailerType(trailerDTO.getTrailerType());
        }
        if (trailerDTO.getDriverId() != null) {
            Optional<Driver> driver = driverRepository.findById(trailerDTO.getDriverId());
            if (driver.isEmpty()) {
                throw new NoSuchElementException(DriverExceptionTxt + trailerDTO.getDriverId());
            } else {
                trailerToUpdate.setAssignedDriver1(driver.get());

            }
        }
        trailerRepository.save(trailerToUpdate);
        return TrailerConverter.toDTO(trailerToUpdate);
    }


    public void deleteTrailer(Long id) {
        if (!trailerRepository.existsById(id)) {
            throw new NoSuchElementException(trailerExceptionTxt + id);
        }
        trailerRepository.deleteById(id);
    }

}
