package com.ovd.gestiondocument.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TYPES_DOCUMENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;


    // Relation One-to-Many avec les documents
    @OneToMany(mappedBy = "typeDocument")
    private List<Document> documents = new ArrayList<>();
}
