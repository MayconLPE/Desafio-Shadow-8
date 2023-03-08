package com.banco.Main.useCases.exceptionHandler.contaException;

public class ContaNaoEncontradaException extends RuntimeException{
    public ContaNaoEncontradaException(String msg) {
        super(msg);
    }
}
