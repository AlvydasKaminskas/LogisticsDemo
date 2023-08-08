package eu.codeacademy.LogisticsDemo.converters;

import eu.codeacademy.LogisticsDemo.dto.TruckDTO;
import eu.codeacademy.LogisticsDemo.entities.Driver;
import eu.codeacademy.LogisticsDemo.entities.Truck;

public abstract class TruckConverter {

    public static TruckDTO toDTO(Truck truck) {
        TruckDTO truckDTO = null;
        if (truck != null) {
            truckDTO.setId(truck.getId());
            truckDTO.setLicensePlateNumber(truck.getLicensePlateNumber());
            truckDTO.setMake(truck.getMake());
            truckDTO.setModel(truck.getModel());
            truckDTO.setYear(truck.getYear());
            truckDTO.setIsAvailable(truck.getIsAvailable());
            truckDTO.setDriverId(truck.getAssignedDriver().getId());
        }
        return truckDTO;
    }

    public static Truck toEntity(TruckDTO truckDTO) {
        Truck truck = null;
        if(truckDTO != null) {
            truck.setId(truckDTO.getId());
            truck.setLicensePlateNumber(truckDTO.getLicensePlateNumber());
            truck.setMake(truckDTO.getMake());
            truck.setModel(truckDTO.getModel());
            truck.setYear(truckDTO.getYear());
            truck.setIsAvailable(truckDTO.getIsAvailable());
            if (truckDTO.getDriverId() != null) {
                Driver driverEntity = new Driver();
                driverEntity.setId(truckDTO.getDriverId());
                truck.setAssignedDriver(driverEntity);
            }
        }
        return truck;
    }
}
