package com.banco.main.useCases.exceptionHandler;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseError {

    public Date date;
    public HttpStatus httpStatus;
    public String mensagem;

}
