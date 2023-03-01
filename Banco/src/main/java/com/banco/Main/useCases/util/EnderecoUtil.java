package com.banco.Main.useCases.util;

import com.banco.Main.domain.Cliente;
import com.banco.Main.domain.infoCliente.Endereco;
import com.banco.Main.useCases.dtos.ClienteDto;
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
