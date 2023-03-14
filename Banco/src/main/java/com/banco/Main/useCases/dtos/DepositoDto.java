package com.banco.Main.useCases.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DepositoDto {


    private Integer numeroConta;
    private Integer digito;
    private Integer agencia;
    private Double valorDeposito;
    private LocalDateTime data = LocalDateTime.now();


}
