package com.banco.Main.service.impl;

import com.banco.Main.domain.Cliente;
import com.banco.Main.repository.ClienteRepository;
import com.banco.Main.useCases.adapters.ClienteAdapter;
import com.banco.Main.useCases.adapters.ContaAdapter;
import com.banco.Main.useCases.adapters.EnderecoAdapter;
import com.banco.Main.useCases.dtos.ClienteDto;
import com.banco.Main.useCases.dtos.RetornaClienteContaDto;
import com.banco.Main.service.ClienteService;
import com.banco.Main.useCases.util.EnderecoUtil;
import com.banco.Main.useCases.util.GeradorContaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    GeradorContaUtil geradorContaUtil;
    @Autowired
    ClienteAdapter clienteAdapter;
    @Autowired
    ContaAdapter contaAdapter;
    @Autowired
    EnderecoUtil enderecoUtil;
    @Autowired
    EnderecoAdapter enderecoAdapter;

    @Override
    public RetornaClienteContaDto save(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder().nome(clienteDto.getNome()).documento(clienteDto.getDocumento())
                .tipoDocumento(clienteDto.getTipoDocumento()).telefone(clienteDto.getTelefone())
                .email(clienteDto.getEmail()).senha(clienteDto.getSenha()).tipoConta(clienteDto.getTipoConta()).build();

        Cliente cliente1 = clienteAdapter.saveCliente(cliente);

        var conta = geradorContaUtil.gerarContaInit(cliente1);
        var contaCriada = contaAdapter.saveConta(conta);

        var endereco = enderecoUtil.saveEndereco(cliente1,clienteDto);
        var enderecoCriado = enderecoAdapter.save(endereco);

        return RetornaClienteContaDto.builder().idCliente(cliente.getId()).nome(clienteDto.getNome()).telefone(clienteDto.getTelefone())
                .email(clienteDto.getEmail()).tipoConta(clienteDto.getTipoConta()).numeroConta(contaCriada.getNumeroConta())
                .digito(contaCriada.getDigito()).agencia(contaCriada.getAgencia())
                .build();
    }

    @Override
    public Cliente findById(String id) {
        return null;
    }

}
