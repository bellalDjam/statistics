package dz.minagri.stat.customer.entity;

import dz.minagri.stat.customer.enumeration.Gender;
import dz.minagri.stat.customer.enumeration.TypeAccount;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

;

@Getter
@Setter
@Entity(name = "account")

public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

//	@Column(name = "referenceId", nullable = false,unique = true)
//	@Size(min = 2, message = " must have at least two characters")
//	private String referenceId;

    @Column(name = "username", nullable = false,unique = true)
    private String username;
    @NotNull
    private String password;
    @Column(nullable = false)
    @NotNull
    private String createdBy;

    @NotNull
    @Column(name = "createdate",columnDefinition = "DATE")
    private LocalDate createdAt;

    private String updatedBy;

    @Column(name = "updatedate",columnDefinition = "DATE")
    private LocalDate updatedAt;
    @Column(name = "birthdate",columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(name = "lastMailSentDate",columnDefinition = "DATE")
    private LocalDate lastMailSentDate;
    @Column(name = "lastAccess",columnDefinition = "DATE")
    private LocalDate lastAccess;
    @Column(name = "registrationDate",columnDefinition = "DATE")
    private LocalDate registrationDate;
    @Column(name = "lastFailedLoginDate",columnDefinition = "DATE")
    private LocalDate lastFailedLoginDate;


    private String lastLoginIp;
    private String lockReason;
    @Version
    @Column(name = "version")
    private Integer version;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="manager_id")
    private Account manager;

    @OneToMany(mappedBy="manager")
    private List<Account> directs= new ArrayList<Account>();

    @Column(columnDefinition = "text")
    private String shortInfo;

    @NotNull
    private boolean enabled =true;

    @NotNull
    private boolean credentialNonExpired =true;

    @NotNull
    private boolean nonExpired =true;

    @NotNull
    private boolean nonLocked =true;

/*    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="accountrole",joinColumns= {@JoinColumn
            (name="account_Id",referencedColumnName="id")},
            inverseJoinColumns= {@JoinColumn(name="role_Id",referencedColumnName="id")})
    @Fetch(FetchMode.SELECT)
    private List<Role> roles = new ArrayList<>();*/

    @Enumerated(EnumType.STRING)
    private TypeAccount typeAccount;

    @Enumerated(EnumType.STRING)
    private ContributorCredibility contributorCredibility;
    //	@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
