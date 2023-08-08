package eu.codeacademy.LogisticsDemo.converters;

import eu.codeacademy.LogisticsDemo.dto.DriverDTO;
import eu.codeacademy.LogisticsDemo.entities.Driver;
import eu.codeacademy.LogisticsDemo.entities.Trailer;
import eu.codeacademy.LogisticsDemo.entities.Truck;

public abstract class DriverConverter {

    public static DriverDTO toDTO(Driver driver) {
        DriverDTO driverDTO = null;
        if (driver != null) {
            driverDTO.setID(driver.getId());
            driverDTO.setFirstName(driver.getFirstName());
            driverDTO.setLastName(driver.getLastName());
            driverDTO.setAge(driver.getAge());
            driverDTO.setContactNumber(driver.getContactNumber());
            driverDTO.setEmail(driver.getEmail());
            driverDTO.setLicenseNumber(driver.getLicenseNumber());
            driverDTO.setLicenseExpiryDate(driver.getLicenseExpiryDate());
            driverDTO.setTruckId(driver.getTruck().getId());
            driverDTO.setTrailerId(driver.getTrailer().getId());
        }
        return driverDTO;
    }

    public static Driver toEntity(DriverDTO driverDTO) {
        Driver driver = null;
        if (driverDTO != null) {
            driver.setId(driverDTO.getID());
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
}
