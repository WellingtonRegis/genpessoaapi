package com.example.genpessosapi.services.exceptions;

public class PessoaNotFoundException extends  RuntimeException{

    private static final long serialVersionUID = 1l;

    public PessoaNotFoundException(Long id){
        super("Resource not found. Id" + id)    ;
    }
}
