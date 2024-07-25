package dz.minagri.stat.production.entity;

import dz.minagri.stat.location.enumeration.EtatMauvHerb;
import dz.minagri.stat.location.enumeration.EtatSanitaire;
import dz.minagri.stat.location.enumeration.EtatVegetParcelle;
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
@Entity
@Table(name = "aspectparcel")
public class AspectParcel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Version
    private int version;
    @Column(name = "etatsanitaire", nullable = true)
    @Enumerated(EnumType.STRING)
    private EtatSanitaire etatSanitaire;

    @Column(name = "etatvegetparcelle", nullable = true)
    @Enumerated(EnumType.STRING)
    private EtatVegetParcelle etatVegetParcelle;

    @Column(name = "etatmauvherb", nullable = true)
    @Enumerated(EnumType.STRING)
    private EtatMauvHerb etatmauvherb;

    @Column(name = "record_date", columnDefinition = "DATE")
    private LocalDate recorddate;

    @OneToOne()
    @JoinColumn(name = "productionparcel_id", nullable = false)
    private ProductionParcel productionparcel;
}
