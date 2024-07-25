package dz.minagri.stat.customer.repository;

import dz.minagri.stat.customer.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {


    Optional<Role> findById(Long id);
}
