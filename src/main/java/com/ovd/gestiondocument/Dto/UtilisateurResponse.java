package com.ovd.gestiondocument.Dto;

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
public class UtilisateurResponse {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private Set<RoleRequest> roles = new HashSet<>();;

    public UtilisateurResponse fromEntity(Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
        }

        return UtilisateurResponse.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .email(utilisateur.getEmail())
                .build();
    }


}
