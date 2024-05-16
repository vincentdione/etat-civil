package com.ovd.gestiondocument.Dto;

import com.ovd.gestiondocument.models.InfoPersonne;
import com.ovd.gestiondocument.models.Role;
import com.ovd.gestiondocument.models.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoPersonneRequest {

    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String nomMere;
    private String nomPere;
    private String adresse;

    public static InfoPersonneRequest fromEntity(InfoPersonne infoPersonne){
        if (infoPersonne == null){
            return null;
        }

        return InfoPersonneRequest.builder()
                .id(infoPersonne.getId())
                .nom(infoPersonne.getNom())
                .prenom(infoPersonne.getPrenom())
                .dateNaissance(infoPersonne.getDateNaissance())
                .nomMere(infoPersonne.getNomMere())
                .nomPere(infoPersonne.getNomPere())
                .adresse(infoPersonne.getAdresse())
                .build();
    }

    public static InfoPersonne toEntity(InfoPersonneRequest infoPersonneRequest) {
        if (infoPersonneRequest == null){
            return null;
        }
        return InfoPersonne.builder()
                .id(infoPersonneRequest.getId())
                .nom(infoPersonneRequest.getNom())
                .prenom(infoPersonneRequest.getPrenom())
                .dateNaissance(infoPersonneRequest.getDateNaissance())
                .nomMere(infoPersonneRequest.getNomMere())
                .nomPere(infoPersonneRequest.getNomPere())
                .adresse(infoPersonneRequest.getAdresse())
                .build();
    }


}
