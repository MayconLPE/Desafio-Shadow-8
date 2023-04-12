package com.banco.main.useCases.dtos;

import com.banco.main.domain.infoCliente.TipoDocumento;
import com.banco.main.domain.infoConta.NomeBanco;
import com.banco.main.domain.infoConta.TipoConta;
import com.fasterxml.jackson.annotation.JsonFormat;
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
//    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
//    private LocalDateTime registroCadastro;
    private EnderecoDto endereco;
    private NomeBanco nomeBanco; // BANCOPE, BANCOSP;
}
