package dz.minagri.stat.customer.entity;

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
@Table(
        name = "moyencontact"
)
public class MoyenContact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    @Column(name = "fax")
    // @Pattern(regexp =
    // "^((\\+)?[1-9]{1,2})?([-\\s\\.])?((\\(\\d{1,4}\\))|\\d{1,4})(([-\\s\\.])?[0-9]{1,12}){1,2}$")
    private String fax;

    @Column(name = "telephone")
    // @Pattern(regexp =
    // "^((\\+)?[1-9]{1,2})?([-\\s\\.])?((\\(\\d{1,4}\\))|\\d{1,4})(([-\\s\\.])?[0-9]{1,12}){1,2}$")
    private String telephone;

    @Column(name = "gsm")
    // @Pattern(regexp =
    // "^((\\+)?[1-9]{1,2})?([-\\s\\.])?((\\(\\d{1,4}\\))|\\d{1,4})(([-\\s\\.])?[0-9]{1,12}){1,2}$")
    private String gsm;

    @Column(name = "email")
    private String email;
}
