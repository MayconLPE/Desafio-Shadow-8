package com.banco.main.useCases.exceptionHandler.documentosException;

public class CpfInvalidoException extends RuntimeException {
    public CpfInvalidoException(String msg){
        super(msg);
    }
}
