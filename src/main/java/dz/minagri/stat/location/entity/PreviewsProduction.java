package dz.minagri.stat.location.entity;

import dz.minagri.stat.customer.interval.quote.entity.ProductionParcel;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(
        name = "previewsproduction"
)
public class PreviewsProduction implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private String otherdestination;

    private double forCCLS;

    private double forcustumor;

    private double fortransformer;

    private double livestock;

    private String autre;

    @OneToOne()
    @JoinColumn(name ="rga_id",nullable=false)
    private  Rga rga;

    @Column(name = "recolt_date",columnDefinition = "DATE")
    private LocalDate recoltDate;

    @ManyToOne()
    @JoinColumn(name = "productionparcel_id", nullable = false)
    private ProductionParcel productionparcel;

}
