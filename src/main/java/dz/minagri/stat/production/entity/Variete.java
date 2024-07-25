package dz.minagri.stat.production.entity;

import dz.minagri.stat.production.enumeration.OrigineSemence;
import dz.minagri.stat.production.enumeration.TypeCulture;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "variete")
public class Variete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "variete_id")
    private Long id;

    @Version
    private int version;

    private int dureeCroissanceJour;

    private String name;

    @Column(name = "typeculture", nullable = true)
    @Enumerated(EnumType.STRING)
    private TypeCulture typeCulture;

    @Column(name = "originesemence", nullable = true)
    @Enumerated(EnumType.STRING)
    private OrigineSemence origineSemence;

    @ManyToOne
    @JoinColumn(name = "espececultivee_id", nullable = false)
    private EspeceCultivee especeCultivee;
    @ManyToOne(optional = false)
    private EspeceCultivee especeCultivees;

    public EspeceCultivee getEspeceCultivees() {
        return especeCultivees;
    }

    public void setEspeceCultivees(EspeceCultivee especeCultivees) {
        this.especeCultivees = especeCultivees;
    }
}
