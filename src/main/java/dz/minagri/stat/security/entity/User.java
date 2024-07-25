package dz.minagri.stat.security.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by jan on 6/11/2016.
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(
        name = "user_account",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"userName"})}
)
public class User {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    @Column(length = 60)
    private String password;
    private boolean enabled;
    private boolean available;
    private LocalDate registerDate;
    private String job;
    private LocalDateTime lastLoginDate;
    private boolean emailNotification;


    //  @Transient
    // Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

  /*  @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((email == null) ? 0 : email.hashCode());
        return result;
    }*/
}
