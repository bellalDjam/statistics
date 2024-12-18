package dz.minagri.stat.customer.repository;

import dz.minagri.stat.customer.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findById(Long id);

    List<Account> findAll();

    Account findByUsername(String username);

    Account findByEmail(String email);
    
    Account findOneById(Long id);

    void deleteById(Account account);
}
