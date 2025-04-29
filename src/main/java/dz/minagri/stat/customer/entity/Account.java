package dz.minagri.stat.customer.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import dz.minagri.stat.customer.enumeration.Gender;
import dz.minagri.stat.customer.enumeration.TypeAccount;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity(name = "account")

public class Account implements Serializable {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    private String firstName;
    private String lastName;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @NotNull
    private String password;
    @Column(name = "email", unique = true)
    private String email;
    @Column(nullable = false)
    @NotNull
    private String createdBy;
    @NotNull
    @Column(name = "createdate", columnDefinition = "DATE")
    private LocalDate createdAt;
    private String updatedBy;
    @Column(name = "updatedate", columnDefinition = "DATE")
    private LocalDate updatedAt;
    @Column(name = "birthdate", columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(name = "lastMailSentDate", columnDefinition = "DATE")
    private LocalDate lastMailSentDate;
    @Column(name = "lastAccess", columnDefinition = "DATE")
    private LocalDate lastAccess;
    @Column(name = "registrationDate", columnDefinition = "DATE")
    private LocalDate registrationDate;
    @Column(name = "lastFailedLoginDate", columnDefinition = "DATE")
    private LocalDate lastFailedLoginDate;
    private String lastLoginIp;
    private String lockReason;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Account manager;
    @OneToMany(mappedBy = "manager")
    private List<Account> directs = new ArrayList<Account>();
    @Column(columnDefinition = "text")
    private String shortInfo;
    @NotNull
    private boolean enabled = true;
    @NotNull
    private boolean credentialNonExpired = true;
    @NotNull
    private boolean nonExpired = true;
    @NotNull
    private boolean nonLocked = true;
    @ManyToMany
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"))
    private List<Role> role;

    @Enumerated(EnumType.STRING)
    private TypeAccount typeAccount;
    //	@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
