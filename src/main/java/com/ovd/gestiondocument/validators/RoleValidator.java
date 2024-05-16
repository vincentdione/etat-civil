package com.ovd.gestiondocument.validators;

import com.ovd.gestiondocument.Dto.RoleRequest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator {

    public static List<String> validate(RoleRequest roleRequest){
        List<String> errors = new ArrayList<>();

        if(roleRequest == null || !StringUtils.hasLength(roleRequest.getNom())){
            errors.add("Veuillez renseigner le nom du role");
        }
        return errors;
    }
}
