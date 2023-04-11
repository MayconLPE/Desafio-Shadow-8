package com.banco.main.useCases.util;

import com.banco.main.domain.Cliente;
import com.banco.main.domain.infoCliente.Endereco;
import com.banco.main.useCases.dtos.ClienteDto;
import org.springframework.stereotype.Component;
@Component
public class EnderecoUtil {

    public Endereco saveEndereco(Cliente cliente, ClienteDto clienteDto) {
        var endereco = Endereco.builder().idCliente(cliente.getId()).cep(clienteDto.getEndereco().getCep())
                .bairro(clienteDto.getEndereco().getBairro()).numeroEndereco(clienteDto.getEndereco().getNumeroEndereco())
                .rua(clienteDto.getEndereco().getRua()).cidade(clienteDto.getEndereco().getCidade())
                .uf(clienteDto.getEndereco().getUf()).complemento(clienteDto.getEndereco().getComplemento()).build();

        return endereco;
    }

}
