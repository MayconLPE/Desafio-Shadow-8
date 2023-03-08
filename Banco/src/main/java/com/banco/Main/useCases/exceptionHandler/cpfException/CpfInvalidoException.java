package com.banco.Main.useCases.exceptionHandler.cpfException;

public class CpfInvalidoException extends RuntimeException {
    public CpfInvalidoException(String msg){
        super(msg);
    }
}
