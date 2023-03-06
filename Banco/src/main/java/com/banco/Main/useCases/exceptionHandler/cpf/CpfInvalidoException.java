package com.banco.Main.useCases.exceptionHandler.cpf;

public class CpfInvalidoException extends RuntimeException {
    public CpfInvalidoException(String msg){
        super(msg);
    }
}
