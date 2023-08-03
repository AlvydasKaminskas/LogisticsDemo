package eu.codeacademy.LogisticsDemo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String Name;
    private String Email;
    private String PhoneNumber;

}
