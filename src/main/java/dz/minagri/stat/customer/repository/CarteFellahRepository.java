package dz.minagri.stat.customer.repository;

import dz.minagri.stat.customer.entity.CarteFellah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CarteFellahRepository extends JpaRepository<CarteFellah, Long> {
    Optional<CarteFellah> findById(Long id);

    List<CarteFellah> findAll();

    CarteFellah findOneById(Long id);

    List<CarteFellah> findCarteFellahByWilayaId(Long id);

    void deleteById(CarteFellah carteFellah);


}
