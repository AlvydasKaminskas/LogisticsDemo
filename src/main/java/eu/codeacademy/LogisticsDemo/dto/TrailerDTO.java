package eu.codeacademy.LogisticsDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrailerDTO {
    private Long id;
    private String LicensePlateNumber;
    private String TrailerType;
    private Long driverId;
}
