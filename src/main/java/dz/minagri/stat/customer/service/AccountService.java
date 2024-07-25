package dz.minagri.stat.customer.service;

import dz.minagri.stat.customer.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;

}
