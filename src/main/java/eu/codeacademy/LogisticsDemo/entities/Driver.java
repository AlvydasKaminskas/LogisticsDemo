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
    private Long Id;
    @Column(name = "first_name")
    private String FirstName;
    @Column(name = "last_name")
   private String LastName;
    @Column(name = "age")
    private Integer Age;
    @Column(name = "contact_number")
    private String ContactNumber;
    @Column(name = "email")
    private String Email;
    @Column(name = "license_number")
    private String LicenseNumber;
    @Column(name = "license_expiry_date")
    private Date LicenseExpiryDate;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "truck", referencedColumnName ="id")
    private Truck truck;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trailer", referencedColumnName ="id")
    private Trailer trailer;

    @PrePersist
    void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
