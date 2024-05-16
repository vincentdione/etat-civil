package com.ovd.gestiondocument.Dto;


import com.ovd.gestiondocument.models.Document;
import com.ovd.gestiondocument.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DocumentRequest {


    private Long id;
    private String titre;
    private String description;
    private String contenu;

    public static DocumentRequest fromEntity(Document document){
        if (document == null){
            return null;
        }

        return DocumentRequest.builder()
                .id(document.getId())
                .titre(document.getTitre())
                .description(document.getDescription())
                .contenu(document.getContenu())
                .build();
    }

    public static Document toEntity(DocumentRequest documentRequest) {
        if (documentRequest == null){
            return null;
        }
        return Document.builder()
                .id(documentRequest.getId())
                .titre(documentRequest.getTitre())
                .description(documentRequest.getDescription())
                .contenu(documentRequest.getContenu())
                .build();
    }

}
