package com.ovd.gestiondocument.repositories;

import com.ovd.gestiondocument.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
}
