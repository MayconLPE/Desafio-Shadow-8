package com.banco.Main.service;

import com.banco.Main.domain.Cliente;
import com.banco.Main.repository.ClienteRepository;
import com.banco.Main.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
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
