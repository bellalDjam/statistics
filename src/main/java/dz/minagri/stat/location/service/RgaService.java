package dz.minagri.stat.location.service;

import dz.minagri.stat.customer.entity.Account;
import dz.minagri.stat.location.entity.Exploitation;
import dz.minagri.stat.location.entity.Rga;
import dz.minagri.stat.location.enumeration.RgaQuality;
import dz.minagri.stat.location.repository.RgaRepository;
import dz.minagri.stat.production.entity.PreviewsProduction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class RgaService {

    private final RgaRepository rgaRepository;

    public Collection<Rga> List(int limit) {
        log.info("fetching all rgaServices:{}");
        return rgaRepository.findAll(PageRequest.of(0, limit)).getContent();

    }

    public Rga save(String noteSupervisor, String noteAgent, String noteExploitant,
                    String description, Account account, RgaQuality rgaQuality,
                    LocalDate saisonOpneningDate, LocalDate saisonClosingDate, LocalDate investigationStartingDate,
                    LocalDate investigatioEndDate, PreviewsProduction previewsProduction, Exploitation exploitation) {
        log.info("Save RGA inside RgaServices:{}");
        Rga rga = new Rga();
        rga.setExploitation(exploitation);
        rga.setAccount(account);
        rga.setNoteAgent(noteAgent);
        rga.setRgaQuality(rgaQuality);
        rga.setDescription(description);
        rga.setNoteSupervisor(noteSupervisor);
        rga.setSaisonOpneningDate(saisonOpneningDate);
        rga.setSaisonClosingDate(saisonClosingDate);
        rga.setInvestigationStartingDate(investigationStartingDate);
        rga.setInvestigatioEndDate(investigatioEndDate);
        rga.setPreviewsProduction(previewsProduction);
        return rgaRepository.save(rga);
    }

    public Rga updateRga(Long id, String noteSupervisor, String noteAgent, String noteExploitant,
                         String description, Account account, RgaQuality rgaQuality,
                         LocalDate saisonOpneningDate, LocalDate saisonClosingDate, LocalDate investigationStartingDate,
                         LocalDate investigatioEndDate, PreviewsProduction previewsProduction, Exploitation exploitation
    ) {
        Rga rga = findById(id);
        if (exploitation != null &&
                !Objects.equals(rga.getExploitation(), exploitation)) {
            rga.setExploitation(exploitation);
            log.info("Inside updateRga RGAservice method of rga.setExploitation" + exploitation);
        }
        if (account != null &&
                !Objects.equals(rga.getAccount(), account)) {
            rga.setAccount(account);
            log.info("Inside updateRga RGAservice method of rga.setAccount" + exploitation);
        }
        if (noteAgent != null &&
                noteAgent.length() > 0 &&
                !Objects.equals(rga.getNoteAgent(), noteAgent)) {
            rga.setNoteAgent(noteAgent);
            log.info("Inside updateRga RGAservice method of rga.getNoteAgent()" + noteAgent);
        }
        if (rgaQuality != null &&
                !Objects.equals(rga.getRgaQuality(), rgaQuality)) {
            rga.setRgaQuality(rgaQuality);
            log.info("Inside updateRga RGAservice method of rga.setRgaQuality" + rgaQuality);
        }
        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(rga.getDescription(), description)) {
            rga.setDescription(description);
            log.info("Inside updateRga RGAservice method of rga.setDescription2" + description);
        }
        if (noteSupervisor != null &&
                noteSupervisor.length() > 0 &&
                !Objects.equals(rga.getNoteSupervisor(), noteSupervisor)) {
            rga.setNoteSupervisor(noteSupervisor);
            log.info("Inside updateRga RGAservice method of rga.setNoteSupervisor" + noteSupervisor);
        }
        if (saisonOpneningDate != null &&
                !Objects.equals(rga.getSaisonOpneningDate(), saisonOpneningDate)) {
            rga.setSaisonOpneningDate(saisonOpneningDate);
            log.info("Inside updateRga RGAservice method of rga.setSaisonOpneningDate" + saisonOpneningDate);
        }
        if (saisonClosingDate != null &&
                !Objects.equals(rga.getSaisonClosingDate(), saisonClosingDate)) {
            rga.setSaisonClosingDate(saisonClosingDate);
            log.info("Inside updateRga RGAservice method of rga.setSaisonClosingDate(saisonClosingDate);" + saisonClosingDate);
        }
        if (investigationStartingDate != null &&
                !Objects.equals(rga.getInvestigationStartingDate(), investigationStartingDate)) {
            rga.setInvestigationStartingDate(investigationStartingDate);
            log.info("Inside updateRga RGAservice method of rga.setInvestigationStartingDate" + investigationStartingDate);
        }
        if (investigatioEndDate != null &&
                !Objects.equals(rga.getInvestigatioEndDate(), investigatioEndDate)) {
            rga.setInvestigatioEndDate(investigatioEndDate);
            log.info("Inside updateRga RGAservice method of setInvestigatioEndDate" + investigatioEndDate);
        }
        if (previewsProduction != null &&
                !Objects.equals(rga.getPreviewsProduction(), previewsProduction)) {
            rga.setPreviewsProduction(previewsProduction);
            log.info("Inside updateRga RGAservice method of setPreviewsProduction" + previewsProduction);
        }
        return rgaRepository.save(rga);
    }

    public Optional<Rga> findRgaById(Long rgaId) {
        log.info("findRgaById inside  RgaServices:{}" + rgaId);
        return Optional.ofNullable(rgaRepository.findById(rgaId).orElseThrow(() -> new IllegalArgumentException("RGA with id " + rgaId + "does not exist")));
    }

    public Rga findById(Long id) {
        log.info("findById inside  RgaServices:{}" + id);
        return rgaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("RGA with id " + id + "does not exist"));
    }

    public void deleteRgaByID(Long id) {
        Rga rga = findById(id);
        rgaRepository.delete(rga);
    }
}
