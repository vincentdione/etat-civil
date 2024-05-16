package com.ovd.gestiondocument.Dto;


import com.ovd.gestiondocument.models.TypeDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeDocumentRequest {

    private Long id;
    private String nom;

    public static TypeDocumentRequest fromEntity(TypeDocument type){
        if (type == null){
            return null;
        }

        return TypeDocumentRequest.builder()
                .id(type.getId())
                .nom(type.getNom())
                .build();
    }

    public static TypeDocument toEntity(TypeDocumentRequest typeDocumentRequest) {
        if (typeDocumentRequest == null){
            return null;
        }
        return TypeDocument.builder()
                .id(typeDocumentRequest.getId())
                .nom(typeDocumentRequest.getNom())
                .build();
    }

}
