package com.ovd.gestiondocument.services;

import com.ovd.gestiondocument.Dto.TypeDocumentRequest;

import java.util.List;

public interface TypeDocumentService {

    public TypeDocumentRequest save(TypeDocumentRequest request);
    public List<TypeDocumentRequest> getAllTypeDocuments();

    public TypeDocumentRequest getTypeDocumentById(Long id);


    public void deleteTypeDocument(Long id);
}
