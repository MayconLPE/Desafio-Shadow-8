package com.banco.Main.useCases.adapters;

import com.banco.Main.domain.Cliente;
import com.banco.Main.domain.Conta;
import com.banco.Main.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContaAdapter {
    @Autowired
    ContaRepository contaRepository;

    public Conta saveConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Optional<Cliente> findByDocumento(String documento) {
        return contaRepository.findByDocumento(documento);
    }

    public Conta findByNumeroConta(Integer numeroConta) {
        return contaRepository.findByNumeroConta(numeroConta);
    }
}
