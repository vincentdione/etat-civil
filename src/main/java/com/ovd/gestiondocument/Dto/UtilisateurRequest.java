package com.ovd.gestiondocument.Dto;

import com.ovd.gestiondocument.models.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilisateurRequest {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private Set<RoleRequest> roles = new HashSet<>();;

    public UtilisateurRequest fromEntity(Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
        }

        return UtilisateurRequest.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .email(utilisateur.getEmail())
                .build();
    }

    public Utilisateur toEntity (UtilisateurRequest utilisateurRequest) {
        if (utilisateurRequest == null){
            return null;
        }
        return Utilisateur.builder()
                .nom(utilisateurRequest.getNom())
                .prenom(utilisateurRequest.getPrenom())
                .email(utilisateurRequest.getEmail())
                .motDePasse(utilisateurRequest.getMotDePasse())
                .build();
    }

}
