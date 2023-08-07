package eu.codeacademy.LogisticsDemo.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trailer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trailer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String LicensePlateNumber;
    private String TrailerType;
    private Boolean IsAvailable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;




}
