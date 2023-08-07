package eu.codeacademy.LogisticsDemo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "load")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double Weight;
    private String Origin;
    private String Destination;
    private String Description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
