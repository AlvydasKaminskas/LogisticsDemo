package eu.codeacademy.LogisticsDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DispatchDTO {
    private Long id;
    private String Name;
    private String Email;
    private  String PhoneNumber;
}
