package dz.minagri.stat.location.repository;

import dz.minagri.stat.location.entity.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CommuneRepository extends JpaRepository<Commune,Long> {
    List<Commune> findByNameLike(String name);
    Commune save(Commune commune);
  //  List<Commune> findAllByNameContainingIgnoreCase(String name);
  //  List<Commune> findAllCommunesAndCommuneNomCommuneContainingIgnoreCase(String nomCommune);
   Commune findByname(String name);

    Commune findByName(String s);

    //  Commune findOneByName(String name);
}
