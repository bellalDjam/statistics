package dz.minagri.stat.location.service;

import dz.minagri.stat.location.entity.Rga;
import dz.minagri.stat.location.repository.RgaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class RgaService {

    private final RgaRepository rgaRepository;

    public Collection<Rga> List(int limit) {
        log.info("fetching all rgaServices:{}" );
        return rgaRepository.findAll(PageRequest.of(0,limit)).getContent();

    }
    public Rga save(Rga rga){
        log.info("Save Zone inside RgaServices:{}");
        return rgaRepository.save(rga);

    }


    public Optional<Rga> findRgaById(Long rgaId) {
        log.info("findRgaById inside  RgaServices:{}" + rgaId);
        return rgaRepository.findById(rgaId);
    }

    public Rga findById(Long id) {
        log.info("findById inside  RgaServices:{}" + id);
        return rgaRepository.findById(id).get();
    }
}
