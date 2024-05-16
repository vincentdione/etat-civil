package com.ovd.gestiondocument.repositories;

import com.ovd.gestiondocument.models.InfoPersonne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InfoPersonneRepository extends JpaRepository<InfoPersonne,Long> {
    Optional<InfoPersonne> findInfoPersonneByNom(String nom);
}
