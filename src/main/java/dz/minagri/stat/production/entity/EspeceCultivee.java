package dz.minagri.stat.production.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "espececultivee")
public class EspeceCultivee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private int dureeCroissanceJour;
    private String name;


    @OneToMany(mappedBy = "especeCultivee")
    private List<Variete> varieties = new ArrayList<Variete>();

    public void AddVariete(Variete variete) {
        variete.setEspeceCultivee(this);
        varieties.add(variete);
    }

}
