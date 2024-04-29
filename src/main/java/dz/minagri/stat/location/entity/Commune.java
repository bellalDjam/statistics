package dz.minagri.stat.location.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import dz.minagri.stat.location.enumeration.TypeCommune;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
        name = "commune"
)
public class Commune implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Version
    private int version;

    @Column(name = "name",unique=true)
    private String name;


    @ManyToOne(cascade = CascadeType.ALL)
    //@JsonIdentityReference(alwaysAsId=true)
    @JoinColumn(name = "wilaya_id")
    // @JsonBackReference
    private Wilaya wilaya;

    @Column(name = "type_commune")
    @Enumerated(EnumType.STRING)
    private TypeCommune typeCommune;

    private Integer caract1;

    private String caract2;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
   // @JsonManagedReference
    @JsonIgnore
    private List<Zone> zones = new ArrayList<>();

    @Column(name = "codesubdivision")
    private Long codeSubdiv;

    @Column(unique= true, name = "codecommune" )
    private Long codeCommune;

    @OneToMany(mappedBy = "commune", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Address> adresses;

    public void addZone(Zone zn) {
        zones.add(zn);
        zn.setCommune(this);
    }
    public void addZones(Collection<Zone> zns){
        zns.stream().forEach(this::addZone);
    }
   /* public void listZones(Collection<Zone> zns){
        final long[] i = {0};
        return zns.stream().forEach(this::;
    }*/

    private void getZones(Zone zone) {
    }
}
