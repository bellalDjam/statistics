package dz.minagri.stat.customer.control;

import dz.minagri.stat.customer.entity.Account;
import dz.minagri.stat.customer.enumeration.Gender;
import dz.minagri.stat.customer.enumeration.TypeAccount;
import dz.minagri.stat.customer.service.AccountService;
import dz.minagri.stat.customer.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;
    private final RoleService RoleService;

    @GetMapping(path = "/{id}")
    public Account findAccountById(@PathVariable("id") Long id) {
        log.info("Inside findAccountById method of AccountController");
        return accountService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public Collection<Account> getAll() {
        log.info("Inside findAllAccount method of AccountController");
        return accountService.listAll();
    }

    @PostMapping()
    public Account saveAccount(@RequestParam String lastName, String firstName, String usertName,
                               String email, String createdBy, LocalDate createdAt,
                               LocalDate birthDate, LocalDate registrationDate,
                               Account manager, Boolean enabled, Boolean nonLocked,
                               TypeAccount typeAccount,
                               Gender gender) {
        return accountService.saveAccount(lastName, firstName, usertName, email, createdBy, createdAt, birthDate, registrationDate, manager, enabled, nonLocked, typeAccount, gender);
    }

    @PutMapping(path = "/{id}")
    public Account updateAccount(@PathVariable("id") Long id,
                                 @RequestParam(required = false) String email,
                                 @RequestParam(required = false) String lastName,
                                 @RequestParam(required = false) LocalDate registrationDate,
                                 @RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String usertName,
                                 @RequestParam(required = false) String createdBy,
                                 @RequestParam(required = false) LocalDate createdAt,
                                 @RequestParam(required = false) LocalDate birthDate,
                                 @RequestParam(required = false) Account manager,
                                 @RequestParam(required = false) Boolean enabled,
                                 @RequestParam(required = false) Boolean nonLocked,
                                 @RequestParam(required = false) TypeAccount typeAccount,
                                 @RequestParam(required = false) Gender gender) {
        return accountService.updateAccount(id, lastName, firstName, usertName,
                email, createdBy, createdAt,
                birthDate, registrationDate,
                manager, enabled, nonLocked, typeAccount,
                gender);
    }
}
