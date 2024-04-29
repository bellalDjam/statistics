package dz.minagri.stat.customer.entity;

import dz.minagri.stat.location.entity.Zone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(
        name = "cartefellah"
)
public class CarteFellah implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Version
    private int version;


    @ManyToOne()
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @Column(name = "registration_date",columnDefinition = "DATE")
    private LocalDate registrationDate;

    //private String numS12;

}
