package com.ovd.gestiondocument.repositories;

import com.ovd.gestiondocument.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findRoleByNom(String nom);
}
