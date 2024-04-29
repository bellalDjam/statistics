package dz.minagri.stat.customer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "personne"
)
public class Personne  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private String name;
}
