package dz.minagri.stat.location.service;

import dz.minagri.stat.location.entity.Exploitation;
import dz.minagri.stat.location.entity.Irrigation;
import dz.minagri.stat.location.enumeration.IrrigartionLifeStatus;
import dz.minagri.stat.location.repository.IrrigationRepository;
import dz.minagri.stat.production.enumeration.TypeDeSourceEaux;
import dz.minagri.stat.production.enumeration.TypeEaux;
import dz.minagri.stat.production.enumeration.TypeIrrigation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class IrrigationService {

    private final IrrigationRepository irrigationRepository;

    public Irrigation findIrrigationById(Long id) {
        return irrigationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Irrigation with id " + id + "does not exist"));
    }

    public List<Irrigation> findAllIrrigations() {
        return irrigationRepository.findAll();
    }

    public Irrigation createIrrigation(LocalDate realisationDate, String name, String otherEnergy, int profondeur,
                                       int consomationElectrique, int consomationGasoil, TypeEaux typeEaux, TypeIrrigation typeIrrigation,
                                       IrrigartionLifeStatus irrigationLifeStatus, Exploitation exploitation,
                                       TypeDeSourceEaux typeDeSourceEaux, Double dLat, Double dLon, Double stockCapacity, Double debit) {
        Irrigation irrigation = Irrigation.builder()
                .realisationDate(realisationDate)
                .name(name)
                .otherEnergy(otherEnergy)
                .profondeur(profondeur)
                .consomationElectrique(consomationElectrique)
                .consomationGasoil(consomationGasoil)
                .typeEaux(typeEaux)
                .typeIrrigation(typeIrrigation)
                .irrigationLifeStatus(irrigationLifeStatus)
                .exploitation(exploitation)
                .typeDeSourceEaux(typeDeSourceEaux)
                .debit(debit)
                .dLat(dLat)
                .dLon(dLon)
                .stockCapacity(stockCapacity)
                .build();
        return irrigationRepository.save(irrigation);
    }

    public Collection<Irrigation> list(int limit) {
        return irrigationRepository.findAll(PageRequest.of(0, limit)).getContent();
    }

    public void delete(Long id) {
        if (findIrrigationById(id) != null) {
            irrigationRepository.deleteById(id);
        }
    }

    public Irrigation updateIrrigation(Long id, LocalDate realisationDate, String name, String otherEnergy, int profondeur, int consomationElectrique, int consomationGasoil, TypeEaux typeEaux, TypeIrrigation typeIrrigation, IrrigartionLifeStatus irrigationLifeStatus, Exploitation exploitation, TypeDeSourceEaux typeDeSourceEaux, Double dLat, Double dLon, Double stockCapacity, Double debit) {
        Irrigation irrigation = findIrrigationById(id);

        return irrigationRepository.save(irrigation);
    }
}
