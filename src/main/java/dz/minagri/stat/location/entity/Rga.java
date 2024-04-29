package dz.minagri.stat.location.entity;

import dz.minagri.stat.customer.entity.Account;
import dz.minagri.stat.customer.entity.Personne;
import dz.minagri.stat.location.enumeration.RgaQuality;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(
        name = "rga"
)
public class Rga implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private int durationInMin;
    private String noteSupervisor;
    private String noteAgent;
    private String noteExploitant;
    private String description;

    @OneToOne()
    @JoinColumn(name ="account_id",nullable=false, insertable=false, updatable=false)
    private Account account;

    @OneToOne()
    @JoinColumn(name ="personne_id",nullable=false, insertable=false, updatable=false)
    private Personne manager;

    @Enumerated(EnumType.STRING)
    private RgaQuality rgaQuality;

    @Column(name = "opnening_date",columnDefinition = "DATE")
    private LocalDate opneningDate;

    @Column(name = "closing_Date",columnDefinition = "DATE")
    private LocalDate closingDate;

    @OneToOne(mappedBy="rga")
    private PreviewsProduction previewsProduction;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "exploitation_id", nullable = false)
    private Exploitation exploitation;
//
//	@ManyToOne()
//	@JoinColumn(name="zone_id")
//	private Zone zone;
//
//	@ManyToOne()
//	@JoinColumn(name="wilaya_id")
//	private Wilaya wilaya;

//	@OneToMany(mappedBy = "rga")
//	private List<ProductionParcel> productionParcels;

}
