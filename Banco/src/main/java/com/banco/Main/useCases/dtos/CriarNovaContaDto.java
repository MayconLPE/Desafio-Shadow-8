package com.banco.Main.useCases.dtos;

import com.banco.Main.domain.infoConta.TipoConta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CriarNovaContaDto {

    private String idCliente;
    private String documento;
    private TipoConta tipoConta;
}
