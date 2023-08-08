package eu.codeacademy.LogisticsDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoadDTO {
    private Long id;
    private Double Weight;
    private String Origin;
    private String Destination;
    private  String Description;
    private Long assignedDriverId; // To represent the ID of the assigned driver
    private Long dispatchId; // To represent the ID of the dispatch that created the load

}
