package dz.minagri.stat.location.service;

import dz.minagri.stat.location.entity.Commune;
import dz.minagri.stat.location.repository.CommuneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class CommuneService {

    private final CommuneRepository communeRepository;

    public Collection<Commune> List(int limit) {
        log.info("fetching all CommuneServices:{}" );
        return communeRepository.findAll(PageRequest.of(0,limit)).getContent();

    }
    public Commune save(Commune commune){
        log.info("Save Commune inside CommuneServices:{}");
        return communeRepository.save(commune);

    }
    public Commune get(Long id){
        log.info("fetching Commune By id inside CommuneServices:{}",id);
        return communeRepository.findById(id).get();

    }
    public Commune update(Commune commune){
        log.info("update Commune inside CommuneServices:{}",commune.getName());
        return communeRepository.save(commune);

    }
    public Boolean deleteById(Long id){
        log.info("delete Commune by id  inside CommuneServices:{}",id);
        communeRepository.deleteById(id);
        return true;

    }

    public Collection<Commune> listAll() {
        log.info("all Commune   inside CommuneServices");
        return communeRepository.findAll();
    }

  /*  public Collection<Zone> listAllCommuneZone(Long idCommune) {
        log.info("all Zone inside CommuneServices");

    }*/
}
