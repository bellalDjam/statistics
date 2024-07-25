package dz.minagri.stat.production.entity;

import dz.minagri.stat.production.enumeration.OrigineSemence;
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
@Table(
        name = "semence"
)
public class Semence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Version
    private int version;
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "variete_id", nullable = true)
    private Variete variete;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cereales_id", nullable = true)
    private Cereales cereales;


    @Column(name = "originesemence", nullable = true)
    @Enumerated(EnumType.STRING)
    private OrigineSemence origineSemence;
}
