package eu.codeacademy.LogisticsDemo.services;

import eu.codeacademy.LogisticsDemo.converters.TruckConverter;
import eu.codeacademy.LogisticsDemo.dto.TruckDTO;
import eu.codeacademy.LogisticsDemo.entities.Driver;
import eu.codeacademy.LogisticsDemo.entities.Truck;
import eu.codeacademy.LogisticsDemo.repositories.DriverRepository;
import eu.codeacademy.LogisticsDemo.repositories.TruckRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TruckService {
    private TruckRepository truckRepository;
    private DriverRepository driverRepository;
    private final String truckExceptionTxt = "Truck not found with id: ";
    private final String DriverExceptionTxt = "Driver not found with id: ";

    public List<TruckDTO> getAllTruckDTO() {
        return TruckConverter.toDTOList(truckRepository.findAll());
    }

    public Page<Truck> getAllTruckDTOByModel(String model, Pageable pageable) {
        if (model != null) {
            return this.truckRepository.findTrucksByModel(model, pageable);
        }
        return truckRepository.findTrucksByModel(null, pageable);
    }

    public TruckDTO getTruckDTOById(Long id) {
        if (truckRepository.findById(id) == null) {
            throw new NoSuchElementException(truckExceptionTxt + id);
        } else {
            return TruckConverter.toDTO(truckRepository.findById(id).get());
        }
    }

    public TruckDTO createTruck(TruckDTO truckDto) {
        truckRepository.save(TruckConverter.toEntity(truckDto));
        return truckDto;
    }

    public TruckDTO updateTruck(TruckDTO truckDTO) {
        Truck truckToUpdate = truckRepository.findById(truckDTO.getId()).get();
        if (truckDTO.getLicensePlateNumber() != null) {
            truckToUpdate.setLicensePlateNumber(truckDTO.getLicensePlateNumber());
        }
        if (truckDTO.getMake() != null) {
            truckToUpdate.setMake(truckDTO.getMake());
        }
        if (truckDTO.getModel() != null) {
            truckToUpdate.setModel(truckDTO.getModel());
        }
        if (truckDTO.getYear() != null) {
            truckToUpdate.setYear(truckDTO.getYear());
        }
        if (truckDTO.getDriverId() != null) {
            Optional<Driver> driver = driverRepository.findById(truckDTO.getDriverId());
            if (!driver.isEmpty()) {
                truckToUpdate.setAssignedDriver(driverRepository.findById(truckDTO.getDriverId()).get());
            } else {
                throw new NoSuchElementException(DriverExceptionTxt + truckDTO.getDriverId());
            }
        }
        truckRepository.save(truckToUpdate);
        return TruckConverter.toDTO(truckToUpdate);
    }


    public void deleteTruck(Long id) {
        if (!truckRepository.existsById(id)) {
            throw new NoSuchElementException(truckExceptionTxt + id);
        }
        truckRepository.deleteById(id);
    }
}
