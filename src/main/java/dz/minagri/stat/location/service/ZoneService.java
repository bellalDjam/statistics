package dz.minagri.stat.location.service;

import dz.minagri.stat.location.entity.Zone;
import dz.minagri.stat.location.repository.ZoneRepository;
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
public class ZoneService {

    private final ZoneRepository zoneRepository;

    public Collection<Zone> List(int limit) {
        log.info("fetching all departmentServices:{}" );
        return zoneRepository.findAll(PageRequest.of(0,limit)).getContent();

    }

    public Collection<Zone> listAll() {
        log.info("fetching all departmentServices:{}" );
        return zoneRepository.findAll();

    }

    public Zone findZoneId(Long id){
        log.info("findOne Zone inside ZoneServices:{}");
        return zoneRepository.findById(id).get();
    }
    public Zone save(Zone zone){
        log.info("Save Zone inside ZoneServices:{}");
        return zoneRepository.save(zone);

    }

    public Collection<Zone> listAllCommuneZone(Long idCommune) {
        log.info("listAllCommuneZone inside zoneServices");
        return zoneRepository.findZoneByCommuneId(idCommune);

    }
    public Zone findZoneById(Long zoneId) {
        log.info("findById inside  zoneServices:{}" + zoneId);
        return zoneRepository.findById(zoneId).get();
    }
}
