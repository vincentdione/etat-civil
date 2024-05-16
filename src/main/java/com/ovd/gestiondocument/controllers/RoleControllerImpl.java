package com.ovd.gestiondocument.controllers;

import com.ovd.gestiondocument.Dto.RoleRequest;
import com.ovd.gestiondocument.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleControllerImpl implements RoleController {

    private final RoleService roleService;

    @Override
    public RoleRequest save(RoleRequest request) {
        return roleService.save(request);
    }

    @Override
    public List<RoleRequest> getAllRoles() {
        return roleService.getAllRoles();
    }

    @Override
    public RoleRequest getRoleById(Long id) {
        return roleService.getRoleById(id);
    }

    @Override
    public RoleRequest getRoleByNome(String nom) {
        return roleService.getRoleByNome(nom);
    }

    @Override
    public void deleteRole(Long id) {
        roleService.deleteRole(id);
    }
}
