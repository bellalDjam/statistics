package dz.minagri.stat.location.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Builder(toBuilder = true)
@Table(
        name = "zone"
)
public class Zone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;
    @Version
    private int version;
    @Column(name = "zone_name")
    @NotBlank(message = "Zone name is mandatory")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    // @JsonIdentityReference(alwaysAsId=true)
    @JoinColumn(name = "commune_id")
    // @JsonBackReference
    private Commune commune;

    private String remarque;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    // @JsonManagedReference
    @JsonIgnore
    private List<Exploitation> exploitations = new ArrayList<Exploitation>() ;

//TODO
    /**
    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
    private List<CarteFellah> carteFellahs= new ArrayList<CarteFellah>() ;
    */

    public  void addExploitation (Exploitation expltations){
        exploitations.add(expltations);
        expltations.setZone(this);
    }
}