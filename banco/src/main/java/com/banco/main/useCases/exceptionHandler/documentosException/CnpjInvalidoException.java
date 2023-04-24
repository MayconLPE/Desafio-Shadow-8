package com.banco.main.useCases.exceptionHandler.documentosException;

public class CnpjInvalidoException extends RuntimeException{
    public CnpjInvalidoException(String msg){
        super(msg);
    }
}
