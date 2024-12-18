package dz.minagri.stat.location.entity;

import dz.minagri.stat.customer.entity.Account;
import dz.minagri.stat.location.enumeration.RgaQuality;
import dz.minagri.stat.production.entity.PreviewsProduction;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "rga")
public class Rga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private int durationInMin;
    private String noteSupervisor;
    private String noteAgent;
    private String noteExploitant;
    private String description;

    @OneToOne()
    @JoinColumn(name = "account_id", nullable = false, insertable = false, updatable = false)
    private Account account;

    @OneToOne()
    @JoinColumn(name = "account_id", nullable = false, insertable = false, updatable = false)
    private Account manager;

    @Enumerated(EnumType.STRING)
    private RgaQuality rgaQuality;

    @Column(name = "Saison_opnening_date", columnDefinition = "DATE")
    private LocalDate SaisonOpneningDate;

    @Column(name = "Saison_closing_Date", columnDefinition = "DATE")
    private LocalDate SaisonClosingDate;

    @Column(name = "investigation_starting_date", columnDefinition = "DATE")
    private LocalDate investigationStartingDate;

    @Column(name = "investigation_end_date", columnDefinition = "DATE")
    private LocalDate investigatioEndDate;

    @OneToOne(mappedBy = "rga")
    private PreviewsProduction previewsProduction;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "exploitation_id", nullable = false)
    private Exploitation exploitation;

    @OneToMany(mappedBy = "rga", cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<ExploitationGlobalAspect> exploitationGlobalAspects;

//	@OneToMany(mappedBy = "rga")
//	private List<ProductionParcel> productionParcels;

}
