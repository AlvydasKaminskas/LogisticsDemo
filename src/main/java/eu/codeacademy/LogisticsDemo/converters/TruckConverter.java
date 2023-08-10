package eu.codeacademy.LogisticsDemo.converters;

import eu.codeacademy.LogisticsDemo.dto.TruckDTO;
import eu.codeacademy.LogisticsDemo.entities.Driver;
import eu.codeacademy.LogisticsDemo.entities.Truck;

import java.util.ArrayList;
import java.util.List;

public abstract class TruckConverter {

    public static TruckDTO toDTO(Truck truck) {
        TruckDTO truckDTO = new TruckDTO();
        if (truck != null) {
            truckDTO.setId(truck.getId());
            truckDTO.setLicensePlateNumber(truck.getLicensePlateNumber());
            truckDTO.setMake(truck.getMake());
            truckDTO.setModel(truck.getModel());
            truckDTO.setYear(truck.getYear());
            if (truck.getAssignedDriver() != null) {
                truckDTO.setDriverId(truck.getAssignedDriver().getId());
            }
        }
        return truckDTO;
    }

    public static Truck toEntity(TruckDTO truckDTO) {
        Truck truck = new Truck();
        if (truckDTO != null) {
            truck.setId(truckDTO.getId());
            truck.setLicensePlateNumber(truckDTO.getLicensePlateNumber());
            truck.setMake(truckDTO.getMake());
            truck.setModel(truckDTO.getModel());
            truck.setYear(truckDTO.getYear());
            if (truckDTO.getDriverId() != null) {
                Driver driverEntity = new Driver();
                driverEntity.setId(truckDTO.getDriverId());
                truck.setAssignedDriver(driverEntity);
            }
        }
        return truck;
    }

    public static List<TruckDTO> toDTOList(Iterable<Truck> trucks) {
        List<TruckDTO> truckDTOList = new ArrayList<>();
        if (trucks != null ) {
            for (Truck trk : trucks) {
                truckDTOList.add(toDTO(trk));
            }
        }
        return truckDTOList;
    }

}
