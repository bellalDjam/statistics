package dz.minagri.stat.location.control;

import dz.minagri.stat.location.entity.Commune;
import dz.minagri.stat.location.entity.Exploitation;
import dz.minagri.stat.location.entity.Zone;
import dz.minagri.stat.location.service.CommuneService;
import dz.minagri.stat.location.service.ZoneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/zones")
@AllArgsConstructor
@Slf4j
public class ZoneController {
    private final ZoneService zoneService;
    private final CommuneService communeService;

    @PostMapping
    public Zone saveZoneService(@RequestParam String zoneName, Long communeId, String note, @RequestParam(required = false) List<Exploitation> exploitationList) {
        Commune commune = communeService.get(communeId);
        Zone zone = Zone.builder()
                .commune(commune)
                .name(zoneName)
                .remarque(note)
                .build();
        return zoneService.save(zone);
    }
   /* @PostMapping
    public ResponseEntity<Response> SaveZone(@RequestBody @Valid Zone zone) {

        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("zone", zoneService.save(zone)))
                        .message("zone Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }*/

    /**
     * @PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
     * public Zone saveZone(@Valid @RequestBody  Zone zone){
     * log.info("Inside saveZone method of ZoneController");
     * return zoneService.save(zone);
     * <p>
     * }
     */
    @PutMapping("{id}")
    public Zone updateZone(@PathVariable("id") Long zoneId,
                           @RequestParam(required = false) String zoneName,
                           @RequestParam(required = false) Long communeId,
                           @RequestParam(required = false) String note,
                           @RequestParam(required = false) List<Exploitation> exploitationList) {
        log.info("Inside updateZone method of ZoneController");
        Zone zone = zoneService.findZoneById(zoneId);
        return zoneService.save(zone);
    }


    @GetMapping("/{id}")
    public Zone findZoneById(@PathVariable("id") Long zoneId) {
        log.info("Inside findZonetById method of ZoneController");
        return zoneService.findZoneById(zoneId);
    }

    @GetMapping("")
    public Collection<Zone> getAllZones() {
        log.info("Inside List method of ZonesController");
        return zoneService.listAll();
    }


    @GetMapping("list/{limit}")
    public Collection<Zone> getZones(@PathVariable("limit") int limit) {
        log.info("Inside List method of ZonesController");
        return zoneService.List(limit);
    }
}
