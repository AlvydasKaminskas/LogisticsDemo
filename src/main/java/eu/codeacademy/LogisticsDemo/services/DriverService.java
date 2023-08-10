package eu.codeacademy.LogisticsDemo.services;

import eu.codeacademy.LogisticsDemo.converters.DriverConverter;
import eu.codeacademy.LogisticsDemo.dto.DriverDTO;
import eu.codeacademy.LogisticsDemo.entities.Driver;
import eu.codeacademy.LogisticsDemo.entities.Trailer;
import eu.codeacademy.LogisticsDemo.entities.Truck;
import eu.codeacademy.LogisticsDemo.repositories.DriverRepository;
import eu.codeacademy.LogisticsDemo.repositories.TrailerRepository;
import eu.codeacademy.LogisticsDemo.repositories.TruckRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DriverService {
    private DriverRepository driverRepository;
    private TruckRepository truckRepository;
    private TrailerRepository trailerRepository;
    private final String DriverExceptionTxt = "Driver not found with id: ";
    private final String TruckExceptionTxt = "Truck not found with id: ";
    private final String TrailerExceptionTxt = "Trailer not found with id: ";

    public List<DriverDTO> getAllDriversDTO() {

        return DriverConverter.toDTOList(driverRepository.findAll());
    }

    public DriverDTO getDriverDTOById(Long id) {
        if (driverRepository.findById(id) != null) {
            return DriverConverter.toDTO(driverRepository.findById(id).get());

        } else {
            throw new NoSuchElementException(DriverExceptionTxt + id);

        }
    }

    public DriverDTO createDriver(DriverDTO driverDTO) {
        driverRepository.save(DriverConverter.toEntity(driverDTO));
        return driverDTO;
    }

    public DriverDTO updateDriver(DriverDTO driverDTO) {
        Driver driverToUpdate = driverRepository.findById(driverDTO.getId()).get();
        if (driverDTO.getFirstName() != null) {
            driverToUpdate.setFirstName(driverDTO.getFirstName());
        }
        if (driverDTO.getLastName() != null) {
            driverToUpdate.setLastName(driverDTO.getLastName());
        }
        if (driverDTO.getAge() != null) {
            driverToUpdate.setAge(driverDTO.getAge());
        }
        if (driverDTO.getContactNumber() != null) {
            driverToUpdate.setContactNumber(driverDTO.getContactNumber());
        }
        if (driverDTO.getEmail() != null) {
            driverToUpdate.setEmail(driverDTO.getEmail());
        }
        if (driverDTO.getLicenseNumber() != null) {
            driverToUpdate.setLicenseNumber(driverDTO.getLicenseNumber());
        }
        if (driverDTO.getLicenseExpiryDate() != null) {
            driverToUpdate.setLicenseExpiryDate(driverDTO.getLicenseExpiryDate());
        }
        if (driverDTO.getTruckId() != null) {
            Optional<Truck> truck = truckRepository.findById(driverDTO.getTruckId());
            if(!truck.isEmpty()){
                driverToUpdate.setTruck(truck.get());
            }else {
                throw new NoSuchElementException(TruckExceptionTxt + driverDTO.getTruckId());
            }
        }
        if (driverDTO.getTrailerId() != null) {
            Optional<Trailer> trailer = trailerRepository.findById(driverDTO.getTrailerId());
            if(!trailer.isEmpty()){
                driverToUpdate.setTrailer(trailer.get());
            }else {
                throw new NoSuchElementException(TrailerExceptionTxt + driverDTO.getTrailerId());
            }
        }
        driverRepository.save(driverToUpdate);
        return DriverConverter.toDTO(driverToUpdate);
    }

    public void deleteDriver(Long id) {
        if (!driverRepository.existsById(id)) {
            throw new NoSuchElementException(DriverExceptionTxt + id);
        }
        driverRepository.deleteById(id);
    }
}
