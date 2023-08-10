package eu.codeacademy.LogisticsDemo.converters;

import eu.codeacademy.LogisticsDemo.dto.TrailerDTO;
import eu.codeacademy.LogisticsDemo.dto.TruckDTO;
import eu.codeacademy.LogisticsDemo.entities.Driver;
import eu.codeacademy.LogisticsDemo.entities.Trailer;
import eu.codeacademy.LogisticsDemo.entities.Truck;

import java.util.ArrayList;
import java.util.List;

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
    public static List<TruckDTO> toDTOList(List<Truck> trucks){
        List<TruckDTO> truckDTOList = null;
        if (trucks != null && !trucks.isEmpty()){
            truckDTOList = new ArrayList<>();
            for (Truck trk : trucks){
                truckDTOList.add(toDTO(trk));
            }
        }
        return truckDTOList;
    }

}
