package dz.minagri.stat.location.control;

import dz.minagri.stat.location.entity.Exploitation;
import dz.minagri.stat.location.entity.Irrigation;
import dz.minagri.stat.location.enumeration.IrrigartionLifeStatus;
import dz.minagri.stat.location.service.IrrigationService;
import dz.minagri.stat.production.enumeration.TypeDeSourceEaux;
import dz.minagri.stat.production.enumeration.TypeEaux;
import dz.minagri.stat.production.enumeration.TypeIrrigation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/irrigation")
@AllArgsConstructor
@Slf4j
public class IrrigationController {

    private final IrrigationService IrrigationService;

    @GetMapping("/{id}")
    public Irrigation getIrrigationById(@PathVariable("id") Long id) {
        log.info("Inside getIrrigationById method of IrrigationController" + id + " ");
        return IrrigationService.findIrrigationById(id);
    }

    @GetMapping("/list/{limit}")
    public Collection<Irrigation> findListIrrigations(@PathVariable("limit") int limit) {
        return IrrigationService.list(limit);
    }

    @PostMapping("")
    public Irrigation save(@RequestParam LocalDate realisationDate,
                           @RequestParam String name,
                           @RequestParam String otherEnergy,
                           @RequestParam(required = false) int profondeur,
                           @RequestParam(required = false) int consomationElectrique,
                           @RequestParam(required = false) int consomationGasoil,
                           @RequestParam TypeEaux typeEaux,
                           @RequestParam(required = false) TypeIrrigation typeIrrigation,
                           @RequestParam IrrigartionLifeStatus irrigationLifeStatus,
                           @RequestParam Exploitation exploitation,
                           @RequestParam(required = false) TypeDeSourceEaux typeDeSourceEaux,
                           @RequestParam(required = false) Double dLat,
                           @RequestParam(required = false) Double dLon,
                           @RequestParam(required = false) Double stockCapacity,
                           @RequestParam(required = false) Double debit) {

        return IrrigationService.createIrrigation(realisationDate, name, otherEnergy, profondeur,
                consomationElectrique, consomationGasoil, typeEaux, typeIrrigation,
                irrigationLifeStatus, exploitation,
                typeDeSourceEaux, dLat, dLon, stockCapacity, debit);
    }

    @PutMapping("/{id}")
    public Irrigation updateIrrigation(@PathVariable("id") Long id,
                                       @RequestParam(required = false) LocalDate realisationDate,
                                       @RequestParam String name,
                                       @RequestParam String otherEnergy,
                                       @RequestParam(required = false) int profondeur,
                                       @RequestParam(required = false) int consomationElectrique,
                                       @RequestParam(required = false) int consomationGasoil,
                                       @RequestParam TypeEaux typeEaux,
                                       @RequestParam(required = false) TypeIrrigation typeIrrigation,
                                       @RequestParam IrrigartionLifeStatus irrigationLifeStatus,
                                       @RequestParam Exploitation exploitation,
                                       @RequestParam(required = false) TypeDeSourceEaux typeDeSourceEaux,
                                       @RequestParam(required = false) Double dLat,
                                       @RequestParam(required = false) Double dLon,
                                       @RequestParam(required = false) Double stockCapacity,
                                       @RequestParam(required = false) Double debit) {

        return IrrigationService.updateIrrigation(id, realisationDate, name, otherEnergy, profondeur,
                consomationElectrique, consomationGasoil, typeEaux, typeIrrigation,
                irrigationLifeStatus, exploitation,
                typeDeSourceEaux, dLat, dLon, stockCapacity, debit);
    }

    @DeleteMapping("/{id}")
    public void deleteIrrigation(@PathVariable("id") Long id) {
        IrrigationService.delete(id);
    }

}
