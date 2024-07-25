package dz.minagri.stat.location.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import dz.minagri.stat.location.enumeration.IrrigartionLifeStatus;
import dz.minagri.stat.production.enumeration.TypeDeSourceEaux;
import dz.minagri.stat.production.enumeration.TypeEaux;
import dz.minagri.stat.production.enumeration.TypeIrrigation;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity(name = "irrigation")
public class Irrigation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Version
    private int version;
    private LocalDate dateRealisation;
    private String name;
    private String otherEnergy;
    private int profondeur;
    private int consomationElectrique;
    private int consomationGasoil;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeEaux typeEaux;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeIrrigation typeIrrigation;
    @Enumerated
    private IrrigartionLifeStatus irrigationLifeStatus;
    @ManyToOne
    @JoinColumn(name = "exploitation_id")
    private Exploitation exploitation;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeDeSourceEaux typeDeSourceEaux;

    @Column(name = "dLat", nullable = true, unique = true)
    private Double dLat;

    @Column(name = "dLon", nullable = true, unique = true)
    private Double dLon;

    private double stockCapacity;
    private double debit;
}
