package com.ovd.gestiondocument.Dto;

import com.ovd.gestiondocument.models.Role;
import com.ovd.gestiondocument.models.Utilisateur;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleRequest {
    private Long id;

    private String nom;

    public static RoleRequest fromEntity(Role role){
        if (role == null){
            return null;
        }

        return RoleRequest.builder()
                .id(role.getId())
                .nom(role.getNom())
                .build();
    }

    public static Role toEntity(RoleRequest roleRequest) {
        if (roleRequest == null){
            return null;
        }
        return Role.builder()
                .nom(roleRequest.getNom())
                .build();
    }

}
