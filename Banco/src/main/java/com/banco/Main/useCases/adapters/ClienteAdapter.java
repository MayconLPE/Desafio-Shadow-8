package com.banco.Main.useCases.adapters;

import com.banco.Main.domain.Cliente;
import com.banco.Main.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClienteAdapter {
    @Autowired
    ClienteRepository clienteRepository;
    public Cliente saveCliente(Cliente cliente){
        cliente.setRegistroCadastro(LocalDateTime.now());
        return clienteRepository.save(cliente);
    }


}
