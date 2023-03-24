package com.banco.Main.useCases.exceptionHandler.documentosException;

public class CpfInvalidoException extends RuntimeException {
    public CpfInvalidoException(String msg){
        super(msg);
    }
}
