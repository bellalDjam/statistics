package dz.minagri.stat.location.control;


import dz.minagri.stat.location.entity.Commune;
import dz.minagri.stat.location.entity.Response;
import dz.minagri.stat.location.entity.Zone;
import dz.minagri.stat.location.service.CommuneService;
import dz.minagri.stat.location.service.ZoneService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/communes")
@AllArgsConstructor
@Slf4j
public class CommuneController {
    private final CommuneService communeService;
    private final ZoneService zoneService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> SaveCommune(@RequestBody @Valid Commune commune){

        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(Map.of("commune",communeService.save(commune)))
                        .message("commune Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    /**   @PutMapping(value ="/save" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Commune saveCommune(@Valid @RequestBody Commune commune){
        log.info("Inside saveCommune method of CommuneController");
        return communeService.save(commune);

    }
    @PutMapping(path = "/{id}")
    public Optional<Zone> updateZone(@PathVariable("id") Long zoneId){
        log.info("Inside updateZone method of ZoneController");
        Zone zone = zoneService.findZoneById(zoneId).get();
        return zoneService.save(zone);

    }
*/

/*    @GetMapping("/{id}")
    public Commune findCommuneById(HttpServletResponse httpServletResponse, @PathVariable("id") Long communeId){
        log.info("Inside findcommuneById method of communeController");
        httpServletResponse.setHeader("Location", "/id");
        httpServletResponse.setStatus(302);
        return communeService.get(communeId);
    }*/
    @GetMapping(path = "/{id}")
    public Commune findCommuneById(@PathVariable("id") Long Id){
        log.info("Inside findcommuneById method of communeController");
        return communeService.get(Id);
    }


/*    @GetMapping("{id}/communeboard")
    public Commune findCommuneById(@PathVariable("id") Long communeId){
        log.info("Inside findcommuneById method of communeController");
        return communeService.get(communeId);
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "")
   // @ResponseStatus(value = HttpStatus.OK)
    public Collection<Commune> getAllcommune() {
        log.info("Inside List method of communeController");
        return communeService.listAll();
    }
    @RequestMapping(method = RequestMethod.GET, value = "{communeid}/zones")
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<Zone> listAllCommuneZone(@PathVariable("communeid/zones") Long communeId) {
        log.info("Inside List method of listAllCommuneZone");
        return zoneService.listAllCommuneZone(communeId);
    }

}
