package com.banco.Main.useCases.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EnderecoDto {
    private String cep;
    private String bairro;
    private String numeroEndereco;
    private String rua;
    private String cidade;
    private String uf;
    private String complemento;
}
