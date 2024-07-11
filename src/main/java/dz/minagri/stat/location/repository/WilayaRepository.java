package dz.minagri.stat.location.repository;

import dz.minagri.stat.location.entity.Wilaya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
@Transactional
public interface WilayaRepository extends JpaRepository<Wilaya,Long> {
    Wilaya findOneBynomWilaya(String nomWilaya);
    Wilaya findByCodeWilaya(Long codeWilaya);
    /**
     * @param filterText
     * @return
     */
    Collection<Wilaya> findByNomWilayaStartsWithIgnoreCase(String filterText);
}
