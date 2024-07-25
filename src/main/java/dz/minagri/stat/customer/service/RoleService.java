package dz.minagri.stat.customer.service;

import dz.minagri.stat.customer.entity.Role;
import dz.minagri.stat.customer.repository.AccountRepository;
import dz.minagri.stat.customer.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class RoleService {
    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;

    public RoleService(RoleRepository roleRepository, AccountRepository accountRepository) {
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
    }

    /**
     * Create a new role along with account
     */
    public ResponseEntity<Object> addRole(Role role) {
        Role newRole = new Role();
        newRole.setRoleType(role.getRoleType());
        newRole.setDescription(role.getDescription());

        newRole.setAccounts(role.getAccounts());
        Role savedRole = roleRepository.save(newRole);
        if (roleRepository.findById(savedRole.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role and Users");

        } else return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");

    }

    /**
     * Delete a specified role given the id
     */
    public ResponseEntity<Object> deleteRole(Long id) {
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);
            if (roleRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }
}