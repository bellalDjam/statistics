package dz.minagri.stat.customer.service;

import dz.minagri.stat.customer.entity.CarteFellah;
import dz.minagri.stat.customer.repository.CarteFellahRepository;
import dz.minagri.stat.location.entity.Wilaya;
import dz.minagri.stat.location.repository.WilayaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class CarteFellahService {

    private final CarteFellahRepository fellahRepository;
    private final WilayaRepository wilayarepository;

    public Collection<CarteFellah> List(int limit) {
        log.info("fetching all fellahRepositoryServices:{}");
        return fellahRepository.findAll(PageRequest.of(0, limit)).getContent();

    }

    public CarteFellah save(CarteFellah carteFellah) {
        log.info("Save carteFellah inside fellahRepositoryServices:{}");
        return fellahRepository.save(carteFellah);

    }

    public CarteFellah get(Long id) {
        log.info("fetching carteFellah By id inside fellahRepositoryServices:{}", id);
        return fellahRepository.findById(id).get();

    }

    public CarteFellah update(CarteFellah carteFellah) {
        log.info("update carteFellah inside fellahRepositoryServices:{}", carteFellah.getNationalS12());
        return fellahRepository.save(carteFellah);

    }

    public Boolean deleteById(Long id) {
        log.info("delete Commune by id  inside fellahRepositoryServices:{}", id);
        fellahRepository.deleteById(id);
        return true;

    }

    public Wilaya findCarteFellahWilaya(Long id) {
        return wilayarepository.findByCodeWilaya(id);
    }

    public Collection<CarteFellah> listAll() {
        log.info("all Commune   inside CommuneServices");
        return fellahRepository.findAll();
    }

    @Transactional
    public void updateCarteFellah(Long carteFellah_id,
                                  Long wilayaId,
                                  LocalDate registartioDate,
                                  String email) {
        CarteFellah carteFellah = fellahRepository.findById(carteFellah_id)
                .orElseThrow(() -> new IllegalArgumentException("carteFellah with id " + carteFellah_id + "does not exist"));
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(carteFellah.getEmail(), email)) {
            carteFellah.setEmail(email);
            log.info("Inside updateCarteFellahservice method of carteFellah.setEmail" + email);
        }
        if (registartioDate != null &&
                !Objects.equals(carteFellah.getRegistrationDate(), registartioDate)) {
            carteFellah.setRegistrationDate(registartioDate);
            log.info("Inside updateCarteFellahservice method of carteFellah.setRegistrationDate" + registartioDate);
        }
        if (wilayaId != null &&
                !Objects.equals(carteFellah.getWilaya(), wilayaId)) {
            Wilaya willaya = wilayarepository.getById(wilayaId);
            carteFellah.setWilaya(willaya);
            log.info("Inside updateCarteFellahservice method of carteFellah.setWilaya" + willaya);
        }
    }

    public String findS12ByCarteFellahId(Long id) {
        CarteFellah carteFellah = fellahRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("carteFellah with id " + id + "does not exist"));
        return carteFellah.getNationalS12();
    }

    public Collection<CarteFellah> listAllByWilaya(Long id) {
        log.info("all CarteFellah   inside listAllByWilaya");
        return fellahRepository.findCarteFellahByWilayaId(id);
    }
}
