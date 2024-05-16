package com.ovd.gestiondocument.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Table(name = "INFO_PERSONNES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoPersonne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String nomMere;
    private String nomPere;
    private String adresse;


    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

}

