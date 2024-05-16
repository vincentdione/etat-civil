package com.ovd.gestiondocument.services;

import com.ovd.gestiondocument.Dto.InfoPersonneRequest;
import com.ovd.gestiondocument.Dto.RoleRequest;

import java.util.List;

public interface InfoPersonneService {

    public InfoPersonneRequest save(InfoPersonneRequest request);
    public List<InfoPersonneRequest> getAllInfoPersonnes();

    public InfoPersonneRequest getInfoPersonneById(Long id);

    public InfoPersonneRequest getInfoPersonneByNom(String nom);

    public void deleteInfoPersonne(Long id);
}
