package com.ovd.gestiondocument.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoPersonneResponse {

    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String nomMere;
    private String nomPere;
    private String adresse;


}
