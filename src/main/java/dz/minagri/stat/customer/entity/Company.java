package dz.minagri.stat.customer.entity;

import dz.minagri.stat.customer.enumeration.PersonPosition;
import dz.minagri.stat.customer.enumeration.LegalForm;
import dz.minagri.stat.customer.enumeration.Type;
import dz.minagri.stat.location.entity.Address;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Column(name = "companyOfficialName", nullable = false)
    private String companyOfficialName;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "registredSince")
    private LocalDate registredSince;

    @Column(name = "companyRating")
    private String companyRating;

    @Column(name = "phone")
    private String phone;

    @Column(name = "vat", unique = true)
    private String vat;


    @Column(name = "otherContact")
    private String otherContact;

    @Column(name = "otherContactPersonPosition")
    @Enumerated(EnumType.STRING)
    private PersonPosition otherContactPersonPosition;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private LegalForm status;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address addressHeadSeat;

}
