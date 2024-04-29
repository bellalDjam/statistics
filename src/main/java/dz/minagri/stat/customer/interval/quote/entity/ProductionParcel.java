package dz.minagri.stat.customer.interval.quote.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(
        name = "production_parcel"
)

public class ProductionParcel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Version
    private int version;
  /*  @ManyToOne
    @JoinColumn(name = "exploitation_id")
    private Exploitation exploitation;

    public Exploitation getExploitation() {
        return exploitation;
    }

    public void setExploitation(Exploitation exploitation) {
        this.exploitation = exploitation;
    }

   */
}