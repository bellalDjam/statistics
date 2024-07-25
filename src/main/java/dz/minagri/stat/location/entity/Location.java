package dz.minagri.stat.location.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@Entity
@Table(
        name = "location"
)
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "locationName", nullable = false)
    private String locationName;

    @Column(name = "email")
    private String email;

    @Column(name = "gsm")
    private String gsm;

    @Column(name = "phone")
    private String phone;

    @Column(name = "vatNumber")
    private String vatNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

}
