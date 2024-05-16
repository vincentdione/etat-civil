package com.ovd.gestiondocument.services;

import com.ovd.gestiondocument.Dto.InfoPersonneRequest;
import com.ovd.gestiondocument.Dto.RoleRequest;
import com.ovd.gestiondocument.exceptions.EntityNotFoundException;
import com.ovd.gestiondocument.exceptions.ErrorCodes;
import com.ovd.gestiondocument.exceptions.InvalidEntityException;
import com.ovd.gestiondocument.models.InfoPersonne;
import com.ovd.gestiondocument.models.Role;
import com.ovd.gestiondocument.repositories.InfoPersonneRepository;
import com.ovd.gestiondocument.validators.InfoPersonneValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InfoPersonneServiceImpl  implements InfoPersonneService {

    private final InfoPersonneRepository infoPersonneRepository;
    @Override
    public InfoPersonneRequest save(InfoPersonneRequest request) {
        List<String> errors = InfoPersonneValidator.validate(request);

        if (!errors.isEmpty()){
            log.error("Type document is not valid {}", request);
            throw  new InvalidEntityException("Les infos de la personne ne sont pas valides", ErrorCodes.INFO_PERSONNE_NOT_FOUND,errors);
        }

        InfoPersonne savedInfoPersonne = infoPersonneRepository.save(InfoPersonneRequest.toEntity(request));
        return InfoPersonneRequest.fromEntity(savedInfoPersonne);
    }

    @Override
    public List<InfoPersonneRequest> getAllInfoPersonnes() {
        return infoPersonneRepository.findAll().stream().map(InfoPersonneRequest::fromEntity).collect(Collectors.toList());
    }

    @Override
    public InfoPersonneRequest getInfoPersonneById(Long id) {
        if (id == null){
            log.error(" Id n'existe pas");
            return null;
        }
        Optional<InfoPersonne> savedInfoPersonne = infoPersonneRepository.findById(id);
        InfoPersonneRequest savedInfoPersonneRequest = InfoPersonneRequest.fromEntity(savedInfoPersonne.get());
        return Optional.of(savedInfoPersonneRequest).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune info avec le nom  = " +id+ " n'a été trouvé",
                        ErrorCodes.INFO_PERSONNE_NOT_FOUND
                )
        );
    }

    @Override
    public InfoPersonneRequest getInfoPersonneByNom(String nom) {
        if (!StringUtils.hasLength(nom)){
            log.error("Nom Role existe pas");
            return null;
        }


        Optional<InfoPersonne>  infoPersonne = infoPersonneRepository.findInfoPersonneByNom(nom);

        InfoPersonneRequest infoPersonneRequest = InfoPersonneRequest.fromEntity(infoPersonne.get());

        return Optional.of(infoPersonneRequest).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune information avec le nom  = " +nom+ " n'a été trouvé",
                        ErrorCodes.INFO_PERSONNE_NOT_FOUND
                )
        );
    }

    @Override
    public void deleteInfoPersonne(Long id) {
        infoPersonneRepository.deleteById(id);
    }
}
