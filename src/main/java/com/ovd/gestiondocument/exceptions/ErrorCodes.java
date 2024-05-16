package com.ovd.gestiondocument.exceptions;

public enum ErrorCodes {

    UTILISATEUR_NOT_FOUND(1000),
    ROLE_NOT_FOUND(2000),
    DOCUMENT_NOT_FOUND(3000),
    INFO_PERSONNE_NOT_FOUND(3000),
    TYPEDOCUMENT_NOT_FOUND(4000);

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
