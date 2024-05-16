package com.ovd.gestiondocument.Dto;


import com.ovd.gestiondocument.models.InfoPersonne;
import com.ovd.gestiondocument.models.TypeDocument;
import com.ovd.gestiondocument.models.Utilisateur;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentResponse {

    private Long id;
    private String titre;
    private String description;
    private String contenu;
}
