package dz.minagri.stat.customer.interval.quote.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
@Entity
@Table(
        name = "category"
)

public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Version
    private int version;
    @NotNull
    private String name;
}
