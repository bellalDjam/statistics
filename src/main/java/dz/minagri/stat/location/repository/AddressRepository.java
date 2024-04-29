package dz.minagri.stat.location.repository;

import dz.minagri.stat.location.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Address,Long> {
    Address findByRueAndNumeroLike(String name, String numero);
    List<Address> findByRueContaining(String rue);
    List<Address> findAll();
    Page<Address> findAll(Pageable pageable);

}
