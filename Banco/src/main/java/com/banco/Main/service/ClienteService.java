package com.banco.Main.service;

import com.banco.Main.domain.Cliente;
import com.banco.Main.repository.ClienteRepository;
import com.banco.Main.service.exceptions.UserNotFoundException;
import com.banco.Main.useCases.adapters.ClienteAdapter;
import com.banco.Main.useCases.adapters.ContaAdapter;
import com.banco.Main.useCases.adapters.EnderecoAdapter;
import com.banco.Main.useCases.dtos.ClienteDto;
import com.banco.Main.useCases.dtos.RetornaClienteContaDto;
import com.banco.Main.useCases.util.EnderecoUtil;
import com.banco.Main.useCases.util.GeradorContaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
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


//    public Cliente save(Cliente cliente) {
//        return clienteRepository.save(cliente);
//    }

    public RetornaClienteContaDto save(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder().nome(clienteDto.getNome()).documento(clienteDto.getDocumento())
                .tipoDocumento(clienteDto.getTipoDocumento()).telefone(clienteDto.getTelefone())
                .email(clienteDto.getEmail()).senha(clienteDto.getSenha()).tipoConta(clienteDto.getTipoConta()).build();

        Cliente cliente1 = clienteAdapter.saveCliente(cliente);

        var conta = geradorContaUtil.gerarContaInit(cliente1);
        var contaCriada = contaAdapter.saveConta(conta);

        var endereco = enderecoUtil.saveEndereco(cliente1,clienteDto);
        var enderecoCriado = enderecoAdapter.save(endereco);

        return RetornaClienteContaDto.builder().nome(clienteDto.getNome()).telefone(clienteDto.getTelefone())
                .email(clienteDto.getEmail()).tipoConta(clienteDto.getTipoConta()).numeroConta(contaCriada.getNumeroConta())
                .digito(contaCriada.getDigito()).agencia(contaCriada.getAgencia())
                .build();
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(String id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new UserNotFoundException());
    }

//    public Optional<Cliente> findById(String id) {
//        Optional<Cliente> optional = clienteRepository.findById(id);
//        return optional;
//    }

//    public Cliente update(Cliente cliente, String id) {
//        cliente.setId(id);
//        return clienteRepository.save(cliente);
//    }

//    public void delete(String id) {
//        clienteRepository.deleteById(id);
//    }
}
