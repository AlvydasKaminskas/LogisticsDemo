package eu.codeacademy.LogisticsDemo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dispatch")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dispatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String Name;
    @Column(name = "email")
    private String Email;
    @Column(name = "phone_number")
    private String PhoneNumber;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "dispatch")
    private List<Load> loads = new ArrayList<>();

}
