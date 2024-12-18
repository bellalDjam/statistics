package dz.minagri.stat.customer.control;

import dz.minagri.stat.customer.entity.CarteFellah;
import dz.minagri.stat.customer.repository.CarteFellahRepository;
import dz.minagri.stat.customer.service.CarteFellahService;
import dz.minagri.stat.location.entity.Wilaya;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
@Slf4j
public class CompanyController {

    private final CarteFellahRepository carteFellahRepository;
    private final CarteFellahService carteFellahService;

    @GetMapping(path = "/{id}")
    public CarteFellah findCarteFellahById(@PathVariable("id") Long id) {
        log.info("Inside findCarteFellahById method of CarteFellahController");
        return carteFellahService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public Collection<CarteFellah> getAll() {
        log.info("Inside findAllCarteFella method of CarteFellahController");
        return carteFellahService.listAll();
    }

    @PostMapping()
    public CarteFellah saveCarteFellah(@RequestParam String nationalS12, String email, Long wilay, LocalDate registrationDate) {
        Wilaya wilaya = carteFellahService.findCarteFellahWilaya(wilay);
        CarteFellah carteFellah = CarteFellah.builder()
                .nationalS12(nationalS12)
                .email(email)
                .wilaya(wilaya)
                .registrationDate(registrationDate)
                .build();

        return carteFellah;
    }

    @PutMapping(path = "/{id}")
    public void updateCarteFellah(@PathVariable("id") Long id,
                                  @RequestParam(required = false) String email,
                                  @RequestParam(required = false) Long wilaya,
                                  @RequestParam(required = false) LocalDate registrationDate
    ) {
        log.info("Inside updateCarteFellah method of CarteFellahController");
        CarteFellah carteFellah = carteFellahService.get(id);
        carteFellahService.updateCarteFellah(id, wilaya, LocalDate.now(), email);
    }
}
