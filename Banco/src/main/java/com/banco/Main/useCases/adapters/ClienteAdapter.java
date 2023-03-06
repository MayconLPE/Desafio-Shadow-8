package com.banco.Main.useCases.adapters;

import com.banco.Main.domain.Cliente;
import com.banco.Main.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ClienteAdapter {
    @Autowired
    ClienteRepository clienteRepository;
    public Cliente saveCliente(Cliente cliente) {
        cliente.setRegistroCadastro(LocalDateTime.now());
        return clienteRepository.save(cliente);
    }
    public Optional<Cliente> findById(String id) {
        return clienteRepository.findById(id);
    }
//    private Optional<Cliente> findByCPF(ClienteDto clienteDto) {
//        Optional<Cliente> obj = clienteRepository.findByDocumento(clienteDto.getDocumento());
//        if (obj != null) {
//            return obj;
//        }
//        return null;
//    }
}
