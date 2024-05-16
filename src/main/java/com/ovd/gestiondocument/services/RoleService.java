package com.ovd.gestiondocument.services;

import com.ovd.gestiondocument.Dto.RoleRequest;
import com.ovd.gestiondocument.Dto.RoleResponse;

import java.util.List;

public interface RoleService {

    public RoleRequest save(RoleRequest request);
    public List<RoleRequest> getAllRoles();

    public RoleRequest getRoleById(Long id);

    public RoleRequest getRoleByNome(String nom);

    public void deleteRole(Long id);

}
