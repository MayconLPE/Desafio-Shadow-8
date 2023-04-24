package com.banco.main.useCases.dtos;

import com.banco.main.domain.infoConta.NomeBanco;
import com.banco.main.domain.infoConta.TipoConta;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RetornaClienteContaDto {

    private String idCliente;
    private String nome;
    private String telefone;
    private String email;
    private TipoConta tipoConta;
    private Integer agencia;
    private Integer numeroConta;
    private Integer digito;
    private NomeBanco nomeBanco; // BANCOPE, BANCOSP;
}
