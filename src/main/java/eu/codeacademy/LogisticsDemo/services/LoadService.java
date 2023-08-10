package eu.codeacademy.LogisticsDemo.services;

import eu.codeacademy.LogisticsDemo.converters.LoadConverter;
import eu.codeacademy.LogisticsDemo.dto.LoadDTO;
import eu.codeacademy.LogisticsDemo.entities.*;
import eu.codeacademy.LogisticsDemo.repositories.DispatchRepository;
import eu.codeacademy.LogisticsDemo.repositories.DriverRepository;
import eu.codeacademy.LogisticsDemo.repositories.LoadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoadService {
    private LoadRepository loadRepository;
    private DispatchRepository dispatchRepository;
    private DriverRepository driverRepository;
    private final String LoadExceptionTxt = "Load not found with id: ";
    private final String DriverExceptionTxt = "Driver not found with id: ";
    private final String DispatchExceptionTxt = "Dispatch not found with id: ";

    public List<LoadDTO> getAllLoadsDTO() {
        return LoadConverter.toDTOList(loadRepository.findAll());
    }
    public LoadDTO getLoadDTOById(Long id) {
        if (loadRepository.findById(id) == null) {
            throw new NoSuchElementException(LoadExceptionTxt + id);


        } else {
            return LoadConverter.toDTO(loadRepository.findById(id).get());

        }
    }
    public LoadDTO createLoad(LoadDTO loadDTO) {
        loadRepository.save(LoadConverter.toEntity(loadDTO));
        return loadDTO;
    }

    public LoadDTO updateLoad(LoadDTO loadDTO) {
         Load loadToUpdate = loadRepository.findById(loadDTO.getId()).get();
        if (loadDTO.getWeight() != null) {
            loadToUpdate.setWeight(loadDTO.getWeight());
        }
        if (loadDTO.getOrigin() != null) {
            loadToUpdate.setOrigin(loadDTO.getOrigin());
        }
        if (loadDTO.getDestination() != null) {
            loadToUpdate.setDestination(loadDTO.getDestination());
        }
        if (loadDTO.getDescription() != null) {
            loadToUpdate.setDescription(loadDTO.getDescription());
        }
        if (loadDTO.getAssignedDriverId() != null) {
            Optional<Driver> driver = driverRepository.findById(loadDTO.getAssignedDriverId());
            if(!driver.isEmpty()){
                loadToUpdate.setDriver(driver.get());
            }else {
                throw new NoSuchElementException(DriverExceptionTxt + loadDTO.getAssignedDriverId());
            }
        }
        if (loadDTO.getDispatchId() != null) {
            Optional<Dispatch> dispatch = dispatchRepository.findById(loadDTO.getDispatchId());
            if(!dispatch.isEmpty()){
                loadToUpdate.setDispatch(dispatch.get());
            }else {
                throw new NoSuchElementException(DispatchExceptionTxt + loadDTO.getDispatchId());
            }
        }
        loadRepository.save(loadToUpdate);
        return LoadConverter.toDTO(loadToUpdate);
    }
    public void deleteLoad(Long id) {
        if (!loadRepository.existsById(id)) {
            throw new NoSuchElementException(LoadExceptionTxt + id);
        }
        loadRepository.deleteById(id);
    }






}
