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
public class TruckDTO {
    private Long id;
    private String LicensePlateNumber;
    private String Make;
    private String Model;
    private Date Year;
    private Boolean IsAvailable;
    private Long DriverId;
}
