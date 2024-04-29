package dz.minagri.stat.location.repository;

import dz.minagri.stat.location.entity.Rga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface RgaRepository extends JpaRepository<Rga,Long> {
    Optional<Rga> findById(Long id);
    Rga save(Rga rga);

    @Override
    void deleteById(Long aLong);

    List<Rga> findAll();

}
