package com.banco.Main.useCases.exceptionHandler;

import com.banco.Main.useCases.exceptionHandler.cpf.CpfInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class Exceptions extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DocumentoInvalidoException.class)
    public ResponseEntity cpfInvalidoError(DocumentoInvalidoException e) {
        var date = new Date();
        ResponseError responseError = new ResponseError(date, HttpStatus.BAD_REQUEST, "CPF Inválido");
        return ResponseEntity.status(responseError.httpStatus).body(responseError);
    }
}
