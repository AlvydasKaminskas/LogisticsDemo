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
    @Column(name = "license_plate_number")
    private String LicensePlateNumber;
    @Column(name = "type")
    private String TrailerType;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @OneToOne(mappedBy = "trailer",cascade = CascadeType.ALL)
    private Driver assignedDriver1;

    @PrePersist
    void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }



}
