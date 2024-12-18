package dz.minagri.stat.location.repository;

import dz.minagri.stat.location.entity.Irrigation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IrrigationRepository extends JpaRepository<Irrigation, Long> {

    List<Irrigation> findAll();

    Page<Irrigation> findAll(Pageable pageable);

    Optional<Irrigation> findById(Long id);

    Irrigation findOneById(Long id);

    Irrigation findByName(String name);

    List<Irrigation> findAllByName(String name);

    void deleteById(Long id);
}
