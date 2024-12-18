package dz.minagri.stat.customer.service;

import dz.minagri.stat.customer.entity.Account;
import dz.minagri.stat.customer.enumeration.Gender;
import dz.minagri.stat.customer.enumeration.TypeAccount;
import dz.minagri.stat.customer.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;

    public Account get(Long id) {
        log.info("fetching all AccountRepositoryServices:{}");
        return accountRepository.findOneById(id);
    }

    public Collection<Account> listAll() {
        log.info("listall AccountRepositoryServices:{}");
        return accountRepository.findAll();
    }

    public Account saveAccount(String lastName, String firstName, String usertName,
                               String email, String createdBy, LocalDate createdAt,
                               LocalDate birthDate, LocalDate registrationDate,
                               Account manager, Boolean enabled, Boolean nonLocked, TypeAccount typeAccount,
                               Gender gender) {
        Account account = Account.builder()
                .lastName(lastName)
                .firstName(firstName)
                .gender(gender)
                .birthDate(birthDate)
                .username(usertName)
                .email(email)
                .createdBy(createdBy)
                .createdAt(createdAt)
                .manager(manager)
                .enabled(false)
                .nonLocked(false)
                .typeAccount(typeAccount)
                .registrationDate(registrationDate)
                .build();
        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, String lastName, String firstName, String usertName,
                                 String email, String createdBy, LocalDate createdAt,
                                 LocalDate birthDate, LocalDate registrationDate,
                                 Account manager, Boolean enabled, Boolean nonLocked, TypeAccount typeAccount,
                                 Gender gender) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("carteFellah with id " + id + "does not exist"));
        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(account.getFirstName(), firstName)) {
            account.setFirstName(firstName);
            log.info("Inside updateAccountservice method of updateAccount.setfirstName" + firstName);
        }
        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(account.getLastName(), lastName)) {
            account.setLastName(lastName);
            log.info("Inside updateAccountservice method of updateAccount.setlastName" + lastName);
        }
        if (usertName != null &&
                usertName.length() > 0 &&
                !Objects.equals(account.getUsername(), usertName)) {
            account.setUsername(usertName);
            log.info("Inside updateAccountservice method of updateAccount.setusertName" + usertName);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(account.getEmail(), email)) {
            account.setEmail(email);
            log.info("Inside updateAccountservice method of updateAccount.setEmail" + email);
        }
        if (createdBy != null &&
                createdBy.length() > 0 &&
                !Objects.equals(account.getCreatedBy(), createdBy)) {
            account.setCreatedBy(createdBy);
            log.info("Inside updateAccountservice method of updateAccount.setcreatedBy" + createdBy);
        }
        if (createdAt != null &&
                !Objects.equals(account.getCreatedAt(), createdAt)) {
            account.setCreatedAt(createdAt);
            log.info("Inside updateAccountservice method of updateAccount.setcreatedBy" + createdBy);
        }
        if (registrationDate != null &&
                !Objects.equals(account.getRegistrationDate(), registrationDate)) {
            account.setRegistrationDate(registrationDate);
            log.info("Inside updateAccountservice method of updateAccount.setRegistrationDate" + registrationDate);
        }

        if (manager != null &&
                !Objects.equals(account.getManager(), manager)) {
            account.setManager(manager);
            log.info("Inside updateAccountservice method of updateAccount.setmanager" + manager);
        }
        if (enabled != null &&
                !Objects.equals(account.isEnabled(), enabled)) {
            account.setEnabled(enabled);
            log.info("Inside updateAccountservice method of updateAccount.setenabled" + enabled);
        }
        if (nonLocked != null &&
                usertName.length() > 0 &&
                !Objects.equals(account.isNonLocked(), nonLocked)) {
            account.setNonLocked(nonLocked);
            log.info("Inside updateAccountservice method of updateAccount.setNonLocked" + nonLocked);
        }
        if (typeAccount != null &&
                !Objects.equals(account.getTypeAccount(), typeAccount)) {
            account.setTypeAccount(typeAccount);
            log.info("Inside updateAccountservice method of updateAccount.setTypeAccount" + typeAccount);
        }
        if (gender != null &&
                !Objects.equals(account.getGender(), gender)) {
            account.setGender(gender);
            log.info("Inside updateAccountservice method of updateAccount.setGender" + gender);
        }
        account.setUpdatedAt(LocalDate.now());
        return accountRepository.save(account);
    }
}
