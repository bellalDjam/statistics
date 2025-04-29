package dz.minagri.stat.production.entity;

import dz.minagri.stat.location.entity.Irrigation;
import dz.minagri.stat.location.entity.Exploitation;
import dz.minagri.stat.location.enumeration.TypeCulture;
import dz.minagri.stat.production.enumeration.OrigineSemence;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "productionparcel")
public class ProductionParcel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private LocalDate startingSaison;
    private LocalDate endingSaison;
    private Integer usedErea;
    private TypeCulture cultureType;
    @ManyToOne
    @JoinColumn(name = "exploitation_id")
    private Exploitation exploitation;
    private double rendementAttend;
    private boolean stressHydrique;
    private boolean rotation;
    private double rotationFrequency;
    private String rotationdescription;
    @Column(name = "plantation_date", columnDefinition = "DATE")
    private LocalDate plantationDate;
    @Column(name = "recolt_date", columnDefinition = "DATE")
    private LocalDate recoltdate;
    @Column(name = "quantity", nullable = true)
    private double quantityprod;
    @Column(name = "surface", nullable = true)
    private String surface;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "irrigation_id", nullable = true)
    private Irrigation irrigation;
    @OneToMany(mappedBy = "productionparcel")
    private List<PreviewsProduction> previewsproductions = new ArrayList<PreviewsProduction>();
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "espececultivee_id", nullable = true)
    private EspeceCultivee espececultivee;
    @Column(name = "originesemence", nullable = true)
    @Enumerated(EnumType.STRING)
    private OrigineSemence origineSemence;
    @OneToOne(mappedBy = "productionparcel")
    private AspectParcel aspectParcel;

    public void addPreviewsProduction(PreviewsProduction previewsproduction) {
        previewsproduction.setProductionparcel(this);
        previewsproductions.add(previewsproduction);
    }

}