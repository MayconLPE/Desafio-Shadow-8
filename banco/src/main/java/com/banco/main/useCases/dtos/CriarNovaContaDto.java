package com.banco.main.useCases.dtos;

import com.banco.main.domain.infoConta.TipoConta;
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
public class CriarNovaContaDto {

    private String idCliente;
    private String documento;
    private TipoConta tipoConta;
}
