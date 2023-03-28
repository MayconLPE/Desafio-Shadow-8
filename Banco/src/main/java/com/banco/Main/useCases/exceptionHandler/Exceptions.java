package com.banco.Main.useCases.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

@ControllerAdvice
public class Exceptions extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DocumentoInvalidoError.class)
    public ResponseEntity cpfInvalidoError(DocumentoInvalidoError e) {
        var date = new Date();
        ResponseError responseError = new ResponseError(date, HttpStatus.BAD_REQUEST, "Documento Inválido");
        return ResponseEntity.status(responseError.httpStatus).body(responseError);
    }
    @ExceptionHandler(ContaNaoEncontradaError.class)
    public ResponseEntity contaInvalida(ContaNaoEncontradaError e) {
        var date = new Date();
        ResponseError responseError = new ResponseError(date, HttpStatus.NOT_FOUND, "Numero da conta não encontrado");
        return ResponseEntity.status(responseError.httpStatus).body(responseError);
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity CpfCnpjJaCadastrados(SQLIntegrityConstraintViolationException e) {
        var date = new Date();
        ResponseError responseError = new ResponseError(date,HttpStatus.BAD_REQUEST, "CPF ou CNPJ ja cadastrado");
        return ResponseEntity.status(responseError.httpStatus).body(responseError);
    }



}
