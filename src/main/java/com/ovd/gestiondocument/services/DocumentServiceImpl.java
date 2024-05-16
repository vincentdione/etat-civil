package com.ovd.gestiondocument.services;

import com.ovd.gestiondocument.models.Document;
import com.ovd.gestiondocument.repositories.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    public List<Document> getAllDocument() {
        return  documentRepository.findAll();
    }

    public void deleteDocument(Long id){
        if(id != null){
            documentRepository.deleteById(id);
        }
        log.info("ID n'existe pas");
    }

    public Document getDocumentById(Long id){
        return documentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid id : "+id));
    }

    public void createDocument(Document document) {
        documentRepository.save(document);
        log.info("Document {} is saved", document.getId());
    }
}
