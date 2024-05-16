package com.ovd.gestiondocument.controllers;


import com.ovd.gestiondocument.Dto.RoleRequest;
import com.ovd.gestiondocument.utils.Constants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(Constants.APP_ROOT)
public interface RoleController {

    @PostMapping(value = "/roles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RoleRequest save(@RequestBody RoleRequest request);

    @GetMapping(value = "/roles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoleRequest> getAllRoles();

    @GetMapping(value = "/roles/{idRole}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RoleRequest getRoleById(@PathVariable("idRole") Long id);

    @GetMapping(value = "/roles/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RoleRequest getRoleByNome(@PathVariable("nom") String nom);

    @DeleteMapping(value = "/roles/delete/{idRole}")
    public void deleteRole(@PathVariable("idRole") Long id);

}
