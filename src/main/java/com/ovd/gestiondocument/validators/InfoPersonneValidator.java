package com.ovd.gestiondocument.validators;

import com.ovd.gestiondocument.Dto.InfoPersonneRequest;
import com.ovd.gestiondocument.Dto.TypeDocumentRequest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class InfoPersonneValidator {


    public static List<String> validate(InfoPersonneRequest infoPersonneRequest){
        List<String> errors = new ArrayList<>();

        if(infoPersonneRequest == null || !StringUtils.hasLength(infoPersonneRequest.getNom())){
            errors.add("Veuillez renseigner le nom de la personne");
        }
        return errors;
    }
}
