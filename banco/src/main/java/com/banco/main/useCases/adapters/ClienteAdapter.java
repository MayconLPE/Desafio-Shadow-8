package com.banco.main.useCases.adapters;

import com.banco.main.domain.Cliente;
import com.banco.main.repository.ClienteRepository;
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

}
