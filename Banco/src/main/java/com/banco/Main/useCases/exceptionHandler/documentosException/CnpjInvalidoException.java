package com.banco.Main.useCases.exceptionHandler.documentosException;

public class CnpjInvalidoException extends RuntimeException{
    public CnpjInvalidoException(String msg){
        super(msg);
    }
}
