package com.ovd.gestiondocument.validators;

import com.ovd.gestiondocument.Dto.RoleRequest;
import com.ovd.gestiondocument.Dto.TypeDocumentRequest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TypeDocValidator {

    public static List<String> validate(TypeDocumentRequest typeDocumentRequest){
        List<String> errors = new ArrayList<>();

        if(typeDocumentRequest == null || !StringUtils.hasLength(typeDocumentRequest.getNom())){
            errors.add("Veuillez renseigner le nom du type");
        }
        return errors;
    }
}
