package com.banco.Main.useCases.dtos;

import com.banco.Main.domain.infoConta.TipoConta;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RetornaClienteContaDto {

    private String idCliente;
    private String nome;
    private String telefone;
    private String email;
    private TipoConta tipoConta;
    private Integer agencia;
    private Integer numeroConta;
    private Integer digito;
}
