package com.banco.Main.useCases.dtos;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
