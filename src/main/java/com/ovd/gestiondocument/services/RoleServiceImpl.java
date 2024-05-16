package com.ovd.gestiondocument.services;

import com.ovd.gestiondocument.Dto.RoleRequest;
import com.ovd.gestiondocument.Dto.RoleResponse;
import com.ovd.gestiondocument.exceptions.EntityNotFoundException;
import com.ovd.gestiondocument.exceptions.ErrorCodes;
import com.ovd.gestiondocument.exceptions.InvalidEntityException;
import com.ovd.gestiondocument.models.Role;
import com.ovd.gestiondocument.repositories.RoleRepository;
import com.ovd.gestiondocument.validators.RoleValidator;
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
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Override
    public RoleRequest save(RoleRequest request) {
        List<String> errors = RoleValidator.validate(request);
        if (!errors.isEmpty()){
            log.error("Role is not valid {}", request);
            throw  new InvalidEntityException("Le role n'est pas valide", ErrorCodes.ROLE_NOT_FOUND,errors);
        }
//        Role role = Role.builder()
//                .nom(request.getNom())
//                .build();

        Role savedRole = roleRepository.save(RoleRequest.toEntity(request));
        return RoleRequest.fromEntity(savedRole);
    }

    @Override
    public List<RoleRequest> getAllRoles() {
        return roleRepository.findAll().stream().map(RoleRequest::fromEntity).collect(Collectors.toList());
    }

    @Override
    public RoleRequest getRoleById(Long id) {
        if (id == null){
            log.error("Id Role est null");
            return null;
        }
        Optional<Role>  role = roleRepository.findById(id);

        RoleRequest roleRequest = RoleRequest.fromEntity(role.get());

        return Optional.of(roleRequest).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun role avec l'id = " +id+ " n'a été trouvé",
                        ErrorCodes.ROLE_NOT_FOUND
                )
                );
    }

    @Override
    public RoleRequest getRoleByNome(String nom) {
        if (!StringUtils.hasLength(nom)){
            log.error("Nom Role existe pas");
            return null;
        }


        Optional<Role>  role = roleRepository.findRoleByNom(nom);

        RoleRequest roleRequest = RoleRequest.fromEntity(role.get());

        return Optional.of(roleRequest).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun role avec le nom  = " +nom+ " n'a été trouvé",
                        ErrorCodes.ROLE_NOT_FOUND
                )
        );
    }

    @Override
    public void deleteRole(Long id) {
        if (id == null){
            log.error("Id Role est null");
            return;
        }
        roleRepository.deleteById(id);

    }
}
