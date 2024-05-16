package com.ovd.gestiondocument.services;

import com.ovd.gestiondocument.Dto.DocumentResponse;
import com.ovd.gestiondocument.models.Document;

import java.util.List;

public interface DocumentService {

    public List<Document> getAllDocument();
    public void deleteDocument(Long id);

    public Document getDocumentById(Long id);

    public void createDocument(Document document);
}
