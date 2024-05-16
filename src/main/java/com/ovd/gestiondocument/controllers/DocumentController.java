package com.ovd.gestiondocument.controllers;

import com.ovd.gestiondocument.models.Document;
import com.ovd.gestiondocument.services.DocumentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentServiceImpl documentService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Document> getAllDocument() {
        return documentService.getAllDocument();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Document getDocumentById(@PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocument(@RequestBody Document document){
        documentService.createDocument(document);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
    }

}
