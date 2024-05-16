package com.ovd.gestiondocument.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeDocumentResponse {

    private Long id;
    private String nom;
    private List<DocumentResponse> documents = new ArrayList<>();



}
