package eu.codeacademy.LogisticsDemo.converters;

import eu.codeacademy.LogisticsDemo.dto.DriverDTO;
import eu.codeacademy.LogisticsDemo.entities.Driver;
import eu.codeacademy.LogisticsDemo.entities.Trailer;
import eu.codeacademy.LogisticsDemo.entities.Truck;

import java.util.ArrayList;
import java.util.List;

public abstract class DriverConverter {

    public static DriverDTO toDTO(Driver driver) {
        DriverDTO driverDTO = new DriverDTO();
        if (driver != null) {
            driverDTO.setId(driver.getId());
            driverDTO.setFirstName(driver.getFirstName());
            driverDTO.setLastName(driver.getLastName());
            driverDTO.setAge(driver.getAge());
            driverDTO.setContactNumber(driver.getContactNumber());
            driverDTO.setEmail(driver.getEmail());
            driverDTO.setLicenseNumber(driver.getLicenseNumber());
            driverDTO.setLicenseExpiryDate(driver.getLicenseExpiryDate());
            if (driver.getTruck() != null) {
                driverDTO.setTruckId(driver.getTruck().getId());
            }
            if (driver.getTrailer() != null) {
                driverDTO.setTrailerId(driver.getTrailer().getId());
            }

        }
        return driverDTO;
    }

    public static Driver toEntity(DriverDTO driverDTO) {
        Driver driver = new Driver();
        if (driverDTO != null) {
            driver.setId(driverDTO.getId());
            driver.setFirstName(driverDTO.getFirstName());
            driver.setLastName(driverDTO.getLastName());
            driver.setAge(driverDTO.getAge());
            driver.setContactNumber(driverDTO.getContactNumber());
            driver.setEmail(driverDTO.getEmail());
            driver.setLicenseNumber(driverDTO.getLicenseNumber());
            driver.setLicenseExpiryDate(driverDTO.getLicenseExpiryDate());
            if (driverDTO.getTruckId() != null) {
                Truck truckEntity = new Truck();
                truckEntity.setId(driverDTO.getTruckId());
                driver.setTruck(truckEntity);
            }
            if (driverDTO.getTrailerId() != null) {
                Trailer trailerEntity = new Trailer();
                trailerEntity.setId(driverDTO.getTrailerId());
                driver.setTrailer(trailerEntity);
            }
        }
        return driver;
    }

    public static List<DriverDTO> toDTOList(List<Driver> drivers) {
        List<DriverDTO> driverDTOList = new ArrayList<>();
        if (drivers != null && !drivers.isEmpty()) {
            for (Driver d : drivers) {
                driverDTOList.add(toDTO(d));
            }

        }
        return driverDTOList;
    }


}
