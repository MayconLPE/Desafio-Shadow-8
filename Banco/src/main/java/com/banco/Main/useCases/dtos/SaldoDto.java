package com.banco.Main.useCases.dtos;

import com.banco.Main.domain.Conta;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SaldoDto {
    private Integer numeroConta;
    private String nomeCliente;
    private Double saldo;

    public SaldoDto(Conta conta) {
        this.numeroConta = conta.getNumeroConta();
        this.nomeCliente = conta.getNomeCliente();
        this.saldo = conta.getSaldo();
    }

}
