package com.ovd.gestiondocument.services;

import com.ovd.gestiondocument.Dto.RoleRequest;
import com.ovd.gestiondocument.Dto.TypeDocumentRequest;
import com.ovd.gestiondocument.exceptions.EntityNotFoundException;
import com.ovd.gestiondocument.exceptions.ErrorCodes;
import com.ovd.gestiondocument.exceptions.InvalidEntityException;
import com.ovd.gestiondocument.models.Role;
import com.ovd.gestiondocument.models.TypeDocument;
import com.ovd.gestiondocument.repositories.TypeDocumentRepository;
import com.ovd.gestiondocument.validators.TypeDocValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TypeDocumentServiceImpl implements TypeDocumentService {

    private final TypeDocumentRepository typeDocumentRepository;
    @Override
    public TypeDocumentRequest save(TypeDocumentRequest request) {

        List<String> errors =  TypeDocValidator.validate(request);

        if (!errors.isEmpty()){
            log.error("Type document is not valid {}", request);
            throw  new InvalidEntityException("Le type de document n'est pas valide", ErrorCodes.TYPEDOCUMENT_NOT_FOUND,errors);
        }
//        Role role = Role.builder()
//                .nom(request.getNom())
//                .build();

        TypeDocument savedType = typeDocumentRepository.save(TypeDocumentRequest.toEntity(request));
        return TypeDocumentRequest.fromEntity(savedType);
    }

    @Override
    public List<TypeDocumentRequest> getAllTypeDocuments() {
        return typeDocumentRepository.findAll().stream().map(TypeDocumentRequest::fromEntity).collect(Collectors.toList()) ;
    }

    @Override
    public TypeDocumentRequest getTypeDocumentById(Long id) {
        if (id == null){
            log.error("Id Type est null");
            return null;
        }

        Optional<TypeDocument> typeDocument = typeDocumentRepository.findById(id);

        TypeDocumentRequest  typeDocumentRequest = TypeDocumentRequest.fromEntity(typeDocument.get());


        return Optional.of(typeDocumentRequest).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun type avec l'id = " +id+ " n'a été trouvé",
                        ErrorCodes.TYPEDOCUMENT_NOT_FOUND
                )
        );
    }

    @Override
    public void deleteTypeDocument(Long id) {
        if (id == null){
            log.error("Id Type est null");
            return;
        }
        typeDocumentRepository.deleteById(id);
    }
}
