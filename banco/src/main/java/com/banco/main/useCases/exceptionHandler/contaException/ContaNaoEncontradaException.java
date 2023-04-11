package com.banco.main.useCases.exceptionHandler.contaException;

public class ContaNaoEncontradaException extends RuntimeException{
    public ContaNaoEncontradaException(String msg) {
        super(msg);
    }
}
