package dz.minagri.stat.customer.entity;

import dz.minagri.stat.customer.enumeration.Position;
import dz.minagri.stat.customer.enumeration.Salutation;
import dz.minagri.stat.customer.enumeration.Status;
import dz.minagri.stat.customer.enumeration.Type;
import dz.minagri.stat.location.entity.Address;
import dz.minagri.stat.location.entity.Location;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(
        name = "customer",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"mail"})}
)
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "clientSince")
    private LocalDate clientSince;

    @Column(name = "clientRating")
    private String clientRating;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phoneHome")
    private String phoneHome;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "recurrence")
    private String recurrence;

    @Column(name = "otherContact")
    private String otherContact;

    @Column(name = "otherContactPosition")
    @Enumerated(EnumType.STRING)
    private Position otherContactPosition;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "salutation")
    @Enumerated(EnumType.STRING)
    private Salutation salutation;

    @Column(name = "critique")
    private String critique;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  //  private List<Quote> quotes = new ArrayList<>();
}
