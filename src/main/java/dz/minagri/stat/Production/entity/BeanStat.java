package dz.minagri.stat.production.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import dz.minagri.stat.production.enumeration.SampleType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity(name = "beanstat")

public class BeanStat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Version
    private int version;
    @Column(name = "sampletype", nullable = true)
    @Enumerated(EnumType.STRING)
    private SampleType sampleType;

    private int episparmettrecar;
    private int nbrgrain1epis;
    private int nbrgrain2epis;
    private int nbrgrain3epis;


    @Column(name = "record_date", columnDefinition = "DATE")
    private LocalDate recorddate;
    @ManyToOne()
    @JoinColumn(name = "productionparcel_id", nullable = false)
    private ProductionParcel productionparcel;

}
