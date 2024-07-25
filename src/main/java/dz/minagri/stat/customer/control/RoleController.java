package dz.minagri.stat.customer.control;

import dz.minagri.stat.customer.entity.Role;
import dz.minagri.stat.customer.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Role")
@Slf4j
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }
}
