package dz.minagri.stat.location.control;

import dz.minagri.stat.location.entity.Rga;
import dz.minagri.stat.location.service.RgaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rga")
@AllArgsConstructor
@Slf4j
public class RgaController {
    private final RgaService rgaService;

    @PostMapping("/save")
    public Rga saveRga(@RequestBody Rga rga){
        log.info("Inside saveZone method of WilayaController");
        return rgaService.save(rga);

    }
  /**  @PostMapping("/{id}/update")
    public Optional<Zone> updateZone(@PathVariable("id") Long zoneId){
        log.info("Inside updateZone method of ZoneController");
        Zone zone = zoneService.findZoneById(zoneId).get();
        return zoneService.save(zone);

    }
*/

    @GetMapping("/{id}")
    public Rga findRgaById(@PathVariable("id") Long Id){
        log.info("Inside findRgaById method of RgaController");
        return rgaService.findById(Id);
    }

    @GetMapping("list/{limit}")
    public Collection<Rga> getRga(@PathVariable("limit") int limit) {
        log.info("Inside List method of RgaController");
        return rgaService.List(limit);
    }
}
