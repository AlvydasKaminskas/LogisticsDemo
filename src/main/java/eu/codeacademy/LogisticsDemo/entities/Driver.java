package eu.codeacademy.LogisticsDemo.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "driver")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long ID;
    private String FirstName;
   private String LastName;
    private Integer Age;
    private String ContactNumber;
    private String Email;
    private String LicenseNumber;
    private Date LicenseExpiryDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
