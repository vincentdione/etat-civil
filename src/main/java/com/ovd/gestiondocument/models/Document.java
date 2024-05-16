package com.ovd.gestiondocument.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DOCUMENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titre;
    private String description;
    private String contenu;

    // Getters, setters et autres propriétés

    // Relation Many-to-One avec l'utilisateur qui a créé le document
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    // Relation Many-to-One avec le type de document
    @ManyToOne
    @JoinColumn(name = "type_document_id")
    private TypeDocument typeDocument;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private List<InfoPersonne> champDocuments = new ArrayList<>();
}

