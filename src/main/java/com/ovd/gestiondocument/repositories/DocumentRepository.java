package com.ovd.gestiondocument.repositories;

import com.ovd.gestiondocument.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}
