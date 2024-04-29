package dz.minagri.stat.location.service;

import dz.minagri.stat.location.entity.Wilaya;
import dz.minagri.stat.location.repository.WilayaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class WilayaService {

    private final WilayaRepository wilayaRepository;

    public Page<Wilaya> List(int limit) {
        log.info("fetching all WilayaServices:{}" );
        return wilayaRepository.findAll(Pageable.ofSize(limit));

    }
    public Wilaya save(Wilaya wilaya){
        log.info("Save Wilaya inside WilayaServices:{}");
        return wilayaRepository.save(wilaya);

    }


    public Wilaya findWilayaById(Long wilayaId) {
        log.info("findById inside  WilayaServices:{}" + wilayaId);
        return wilayaRepository.findById(wilayaId).get();
    }


    public Boolean delete(Long wilayaId) {
        log.info("DeleteById inside  WilayaServices:{}" + wilayaId);
               wilayaRepository.deleteById(wilayaId);
               return true;
    }

    
    public Collection<Wilaya> listAll() {
        log.info("findById inside  WilayaServices list all" );
        return wilayaRepository.findAll();
    }
}
