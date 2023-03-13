package com.banco.Main.useCases.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.Column;
import java.util.Date;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DepositoDto {

    private String idCliente;
    private String idConta;
    private String documento;
    private Integer numeroConta;
    private Double valorDeposito;
    private Double saldoAnterior;
    private Double novoSaldo;

    private Date date;


}
