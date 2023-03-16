package com.banco.Main.useCases.dtos;

import com.banco.Main.domain.infoCliente.TipoDocumento;
import com.banco.Main.domain.infoConta.NomeBanco;
import com.banco.Main.domain.infoConta.TipoConta;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ClienteDto {

    private String nome;
    private String documento;
    private TipoDocumento tipoDocumento;
    private TipoConta tipoConta;
    private String telefone;
    private String email;
    private String senha;
    private LocalDateTime registroCadastro;
    private EnderecoDto endereco;
    private NomeBanco nomeBanco; // BANCOPE, BANCOSP;
}
