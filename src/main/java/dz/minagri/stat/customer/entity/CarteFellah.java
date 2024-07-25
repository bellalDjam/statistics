package dz.minagri.stat.customer.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import dz.minagri.stat.location.entity.Wilaya;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Entity
@EqualsAndHashCode
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Builder(toBuilder = true)
@Table(
        name = "cartefellah"
)
public class CarteFellah implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    @Column(name = "national_s12", unique = true)
    private String nationalS12;

    @Column(name = "email", unique = true, nullable = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "wilaya_id", nullable = true)
    private Wilaya wilaya;

    @Column(name = "registration_date", columnDefinition = "DATE")
    private LocalDate registrationDate;

    public CarteFellah(int version, String nationalS12, Wilaya wilaya, LocalDate registrationDate) {
        this.version = version;
        this.nationalS12 = nationalS12;
        this.wilaya = wilaya;
        this.registrationDate = registrationDate;
    }

    public CarteFellah(Long id, int version, String nationalS12, String email, Wilaya wilaya, LocalDate registrationDate) {
        this.id = id;
        this.version = version;
        this.nationalS12 = nationalS12;
        this.email = email;
        this.wilaya = wilaya;
        this.registrationDate = registrationDate;
    }

    public CarteFellah() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getNationalS12() {
        return nationalS12;
    }

    public void setNationalS12(String nationalS12) {
        this.nationalS12 = nationalS12;
    }

    public Wilaya getWilaya() {
        return wilaya;
    }

    public void setWilaya(Wilaya wilaya) {
        this.wilaya = wilaya;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}