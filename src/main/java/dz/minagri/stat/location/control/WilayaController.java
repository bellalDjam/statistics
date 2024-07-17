package dz.minagri.stat.location.control;

import dz.minagri.stat.customer.entity.CarteFellah;
import dz.minagri.stat.customer.entity.Exploitant;
import dz.minagri.stat.customer.service.CarteFellahService;
import dz.minagri.stat.customer.service.ExploitantService;
import dz.minagri.stat.location.entity.Response;
import dz.minagri.stat.location.entity.Wilaya;
import dz.minagri.stat.location.service.WilayaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/wilayas")
@AllArgsConstructor
@Slf4j
public class WilayaController {
    private final WilayaService wilayaService;
    private final ExploitantService exploitantService;
    private final CarteFellahService carteFellahService;

    /**
     * @GetMapping("/{limit}") public ResponseEntity<Response> getWilayate(@PathVariable("limit") int limit){
     * return ResponseEntity.ok(
     * Response.builder()
     * .timestamp(now())
     * .data(of("wilayas",wilayaService.List(limit)))
     * .message("wilayas retrieved")
     * .status(OK)
     * .statusCode(OK.value())
     * .build()
     * );
     * }
     */
    @GetMapping("/{id}")
    public ResponseEntity<Response> getWilaya(@PathVariable("id") Long id) throws IOException {
        Wilaya wilaya = wilayaService.findWilayaById(id);
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("wilaya", wilaya))
                        .message("wilaya retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<Response> SaveWilaya(@RequestBody @Valid Wilaya wilaya) {

        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("wilaya", wilayaService.save(wilaya)))
                        .message("wilaya Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Response> deleteWilaya(@PathVariable("id") Long id) {
        Wilaya wilaya = wilayaService.findWilayaById(id);
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("deleted", wilayaService.delete(id)))
                        .message("wilaya deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    /**
     * @PutMapping("{id}") public Optional<Zone> updateZone(@PathVariable("id") Long zoneId){
     * log.info("Inside updateZone method of ZoneController");
     * Zone zone = zoneService.findZoneById(zoneId).get();
     * return zoneService.save(zone);
     * <p>
     * }
     * @GetMapping("/{id}") public Wilaya findWilayaById(@PathVariable("id") Long wilayaId){
     * log.info("Inside findWilayatById method of WilayaController");
     * return wilayaService.findWilayaById(wilayaId);
     * }
     **/
    @RequestMapping(method = RequestMethod.GET, value = "")
    @ResponseStatus(value = OK)
    public Collection<Wilaya> getAllwilaya() {
        log.info("Inside List method of WilayaController");
        return wilayaService.listAll();
    }

    @GetMapping("/{id}/exploitantlist/{limit}")
    public Collection<Exploitant> getExploitant(@PathVariable("limit") int limit) {
        log.info("Inside List method of ExploitantController");
        return exploitantService
                .List(limit);
    }

    @GetMapping("/{id}/carteFellahlist")
    public Collection<CarteFellah> getCarteFellah(@PathVariable("id") Long id) {
        log.info("Inside wilaya controller List method of getCarteFellah");
        return carteFellahService.listAllByWilaya(id);
    }
}
