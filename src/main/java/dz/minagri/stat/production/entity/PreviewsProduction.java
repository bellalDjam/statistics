package dz.minagri.stat.production.entity;

import dz.minagri.stat.location.entity.Rga;
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
@Table(name = "previews_production")
public class PreviewsProduction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Version
    private int version;

    private String otherdestination;

    private double forCCLS;

    private double forcustumor;

    private double fortransformer;
    private double selfeUse;

    private double livestock;

    private String autre;

    @OneToOne()
    @JoinColumn(name = "rga_id", nullable = false)
    private Rga rga;

    @Column(name = "recolt_date", columnDefinition = "DATE")
    private LocalDate recoltDate;

    @ManyToOne()
    @JoinColumn(name = "productionparcel_id", nullable = false)
    private ProductionParcel productionparcel;
}
