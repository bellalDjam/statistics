package dz.minagri.stat.location.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(
        name = "address"
)
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;

    @Column(name = "rue")
    @Size(max = 80)
    private String rue;

    @Column(name = "numero")
    private String numero;

    @Column(name = "boitePostale")
    private String boitePostale;

    @Column(name = "codePostal")
    private Long codePostal;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "commune_id", nullable = false)
    private Commune commune;

    @Column(name = "isDefault")
    private Boolean isDefault;

}
