package dz.minagri.stat.location.control;

import dz.minagri.stat.customer.entity.Account;
import dz.minagri.stat.location.entity.Exploitation;
import dz.minagri.stat.location.entity.Rga;
import dz.minagri.stat.location.enumeration.RgaQuality;
import dz.minagri.stat.location.service.RgaService;
import dz.minagri.stat.production.entity.PreviewsProduction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/rga")
@AllArgsConstructor
@Slf4j
public class RgaController {
    private final RgaService rgaService;

    @PostMapping("/save")
    public Rga saveRga(@RequestParam String noteSupervisor,
                       @RequestParam String noteAgent,
                       @RequestParam(required = false) String noteExploitant,
                       @RequestParam(required = false) String description,
                       @RequestParam Account account,
                       @RequestParam(required = false) RgaQuality rgaQuality,
                       @RequestParam LocalDate saisonOpneningDate,
                       @RequestParam LocalDate saisonClosingDate,
                       @RequestParam LocalDate investigationStartingDate,
                       @RequestParam LocalDate investigatioEndDate,
                       @RequestParam(required = false) PreviewsProduction previewsProduction,
                       @RequestParam Exploitation exploitation) {
        log.info("Inside saveRga method of rgaController");
        return rgaService.save(noteSupervisor, noteAgent, noteExploitant, description, account, rgaQuality, saisonOpneningDate,
                saisonClosingDate, investigationStartingDate, investigatioEndDate, previewsProduction, exploitation);

    }

    @GetMapping("/{id}")
    public Rga findRgaById(@PathVariable("id") Long Id) {
        log.info("Inside findRgaById method of RgaController");
        return rgaService.findById(Id);
    }

    @GetMapping("list/{limit}")
    public Collection<Rga> getRga(@PathVariable("limit") int limit) {
        log.info("Inside List method of RgaController");
        return rgaService.List(limit);
    }

    @PutMapping("/{id}")
    public Rga updateRga(@PathVariable("id") Long id,
                         @RequestParam(required = false) String noteSupervisor,
                         @RequestParam(required = false) String noteAgent,
                         @RequestParam(required = false) String noteExploitant,
                         @RequestParam(required = false) String description,
                         @RequestParam(required = false) Account account,
                         @RequestParam(required = false) RgaQuality rgaQuality,
                         @RequestParam(required = false) LocalDate saisonOpneningDate,
                         @RequestParam(required = false) LocalDate saisonClosingDate,
                         @RequestParam(required = false) LocalDate investigationStartingDate,
                         @RequestParam(required = false) LocalDate investigatioEndDate,
                         @RequestParam(required = false) PreviewsProduction previewsProduction,
                         @RequestParam(required = false) Exploitation exploitation
    ) {
        return rgaService.updateRga(id, noteSupervisor, noteAgent, noteExploitant, description, account, rgaQuality, saisonOpneningDate,
                saisonClosingDate, investigationStartingDate, investigatioEndDate, previewsProduction, exploitation);
    }

    @DeleteMapping
    @PutMapping("/{id}")
    public void deleteRga(@PathVariable("id") Long id) {
        rgaService.deleteRgaByID(id);
    }
}
