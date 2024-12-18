package dz.minagri.stat.location.repository;

import dz.minagri.stat.location.entity.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ZoneRepository extends JpaRepository<Zone, Long> {

    Zone save(Zone zone);

    Optional<Zone> findById(Long id);

    //void Delete (Long id);
    List<Zone> findAll();

    Page<Zone> findAll(Pageable pageable);

    List<Zone> findZoneByCommuneId(Long commune);

    Zone findOneByName(String name);
}
