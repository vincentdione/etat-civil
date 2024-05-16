package com.ovd.gestiondocument.Dto;

import com.ovd.gestiondocument.models.Role;
import com.ovd.gestiondocument.models.Utilisateur;
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
public class RoleResponse {
    private Long id;

    private String nom;

}
