package eu.codeacademy.LogisticsDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class DriverDTO {

    private Long Id;
    private String FirstName;
    private String LastName;
    private Integer Age;
    private String ContactNumber;
    private String Email;
    private String LicenseNumber;
    private Date LicenseExpiryDate;
    private Long truckId;
    private Long trailerId;
}
