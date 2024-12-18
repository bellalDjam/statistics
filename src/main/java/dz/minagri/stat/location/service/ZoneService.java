package dz.minagri.stat.location.service;

import dz.minagri.stat.location.entity.Commune;
import dz.minagri.stat.location.entity.Exploitation;
import dz.minagri.stat.location.entity.Zone;
import dz.minagri.stat.location.repository.ZoneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class ZoneService {

    private final ZoneRepository zoneRepository;

    private final CommuneService communeService;

    public Collection<Zone> List(int limit) {
        log.info("fetching all departmentServices:{}");
        return zoneRepository.findAll(PageRequest.of(0, limit)).getContent();

    }

    public Collection<Zone> listAll() {
        log.info("fetching all departmentServices:{}");
        return zoneRepository.findAll();

    }

    public Zone findZoneId(Long id) {
        log.info("findOne Zone inside ZoneServices:{}");
        return zoneRepository.findById(id).get();
    }

    public Zone saveZone(Long communeID, String remarque, List<Exploitation> exploitations, String name) {
        log.info("Save Zone inside ZoneServices:{}");
        if (communeService.get(communeID) != null) {
            Commune commune = communeService.get(communeID);
            Zone zone = Zone.builder()
                    .commune(commune)
                    .name(name)
                    .remarque(remarque)
                    .exploitations(exploitations)
                    .build();
            return zoneRepository.save(zone);
        }
        return null;
    }

    public Collection<Zone> listAllCommuneZone(Long idCommune) {
        log.info("listAllCommuneZone inside zoneServices");
        return zoneRepository.findZoneByCommuneId(idCommune);

    }

    public Zone findZoneById(Long zoneId) {
        log.info("findById inside zoneServices:{}" + zoneId);
        return zoneRepository.findById(zoneId).orElseThrow(() -> new IllegalArgumentException("carteFellah with id " + zoneId + "does not exist"));
    }

    public void deleteZoneById(Long zoneId) {
        if (findZoneById(zoneId) != null) {
            zoneRepository.deleteById(zoneId);
        }
    }

    public Zone updateZone(Long zoneId, Long communeid, String remarque, List<Exploitation> exploitations, String name) {

        Zone zone = findZoneById(zoneId);
        Commune commune = communeService.get(communeid);
        if (communeService.get(communeid) != null &&
                !Objects.equals(zone.getCommune(), commune)) {
            zone.setCommune(commune);
            log.info("Inside updateZoneservice method of zone.setCommune" + commune);
        }
        if (remarque != null &&
                remarque.length() > 0 &&
                !Objects.equals(zone.getRemarque(), remarque)) {
            zone.setRemarque(remarque);
            log.info("Inside updateZoneservice method of zone.setRemarque(remarque)" + remarque);
        }
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(zone.getName(), name)) {
            zone.setName(name);
            log.info("Inside updateZoneservice method of zone.setName(name)" + name);
        }
        if (exploitations != null &&
                !Objects.equals(zone.getName(), exploitations)) {
            zone.setExploitations(exploitations);
            log.info("Inside updateZoneservice method of zone.setExploitations(exploitations)" + exploitations);
        }
        return zoneRepository.save(zone);
    }
}
