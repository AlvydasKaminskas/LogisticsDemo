package eu.codeacademy.LogisticsDemo.converters;

import eu.codeacademy.LogisticsDemo.dto.LoadDTO;
import eu.codeacademy.LogisticsDemo.entities.Dispatch;
import eu.codeacademy.LogisticsDemo.entities.Driver;
import eu.codeacademy.LogisticsDemo.entities.Load;

import java.util.ArrayList;
import java.util.List;

public abstract class LoadConverter {
    public static LoadDTO toDTO(Load load) {
        LoadDTO loadDTO = null;
        loadDTO.setId(load.getId());
        loadDTO.setWeight(load.getWeight());
        loadDTO.setOrigin(load.getOrigin());
        loadDTO.setDestination(load.getDestination());
        loadDTO.setDescription(load.getDescription());
        loadDTO.setAssignedDriverId(load.getAssignedDriver().getId());
        loadDTO.setDispatchId(load.getDispatch().getId());
        return loadDTO;
    }

    public static Load toEntity(LoadDTO loadDTO) {
        Load load = null;
        if (loadDTO != null) {
            load.setId(loadDTO.getId());
            load.setWeight(loadDTO.getWeight());
            load.setOrigin(loadDTO.getOrigin());
            load.setDestination(loadDTO.getDestination());
            load.setDescription(loadDTO.getDescription());
            if (loadDTO.getAssignedDriverId() != null) {
                Driver driverEntity = new Driver();
                driverEntity.setId(loadDTO.getId());
                load.setAssignedDriver(driverEntity);
            }
            if (loadDTO.getDispatchId() != null) {
                Dispatch dispatchEntity = new Dispatch();
                dispatchEntity.setId(loadDTO.getDispatchId());
                load.setDispatch(dispatchEntity);
            }
        }
        return load;
    }

    public static List<LoadDTO> EntitiesToDTOs(Iterable<Load> loadList) {
        List<LoadDTO> loadDTOList = null;
        if (loadList != null) {
            loadDTOList = new ArrayList<>();
            for (Load e : loadList) {
                loadDTOList.add(LoadConverter.toDTO(e));
            }
        }
        return loadDTOList;
    }
}
