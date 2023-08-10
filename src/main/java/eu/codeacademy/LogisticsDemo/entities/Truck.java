package eu.codeacademy.LogisticsDemo.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "truck")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "license_plate_number")
    private String LicensePlateNumber;
    @Column(name = "make")
    private String Make;
    @Column(name = "model")
    private String Model;
    @Column(name = "year")
    private Date Year;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "truck",cascade = CascadeType.ALL)
    private Driver assignedDriver;

    @PrePersist
    void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }





}
