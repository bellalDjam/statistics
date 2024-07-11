package dz.minagri.stat.location.control;

import dz.minagri.stat.location.entity.Response;
import dz.minagri.stat.location.entity.Zone;
import dz.minagri.stat.location.service.ZoneService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/zones")
@AllArgsConstructor
@Slf4j
public class ZoneController {
    private final ZoneService zoneService;
    @PostMapping
    public ResponseEntity<Response> SaveZone(@RequestBody @Valid Zone zone){

        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("zone",zoneService.save(zone)))
                        .message("zone Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    /**
     * @PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
     * public Zone saveZone(@Valid @RequestBody  Zone zone){
     * log.info("Inside saveZone method of ZoneController");
     * return zoneService.save(zone);
     * <p>
     * }
     */
    @PostMapping("{id}")
    public Zone updateZone(@PathVariable("id") Long zoneId){
        log.info("Inside updateZone method of ZoneController");
        Zone zone = zoneService.findZoneById(zoneId);
        return zoneService.save(zone);
    }


    @GetMapping("/{id}")
    public Zone findZoneById(@PathVariable("id") Long zoneId){
        log.info("Inside findZonetById method of ZoneController");
        return zoneService.findZoneById(zoneId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<Zone> getAllZones() {
        log.info("Inside List method of ZonesController");
        return zoneService.listAll();
    }




/*    @GetMapping("list/{limit}")
    public Collection<Zone> getZones(@PathVariable("limit") int limit) {
        log.info("Inside List method of ZonesController");
        return zoneService.List(limit);
    }*/
}
