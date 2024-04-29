package dz.minagri.stat.location.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(
        name = "wilaya"
)
public class Wilaya implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Version
    private int version;

    @Column(name = "nomwilaya", unique= true, nullable = false)
    @NotEmpty(message = "Wilaya ID can't be empty or null")
    private String nomWilaya;

    @Column(name = "codewilaya",unique= true)
    private Long codeWilaya;

    @Column(name = "totarea")
    private Integer totarea;

    @Column(name = "totpopulation")
    private Integer totpopulation;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Commune> communes= new ArrayList<>();

    public void addCommune(Commune com) {
        communes.add(com);
        com.setWilaya(this);
    }
    public void addCommunes(Collection<Commune> coms){
    coms.stream().forEach(this::addCommune);
    }
}
