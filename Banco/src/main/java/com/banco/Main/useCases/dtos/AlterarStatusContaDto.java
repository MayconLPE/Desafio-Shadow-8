package com.banco.Main.useCases.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AlterarStatusContaDto {

    private String numeroConta;
    private String documento;
}
