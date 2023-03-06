package com.banco.Main.useCases.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EnderecoDto {
    private String cep;
    private String bairro;
    private String numeroEndereco;
    private String rua;
    private String cidade;
    private String uf;
    private String complemento;
}
