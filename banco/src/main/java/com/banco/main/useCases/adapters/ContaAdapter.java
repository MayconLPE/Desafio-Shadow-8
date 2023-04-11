package com.banco.main.useCases.adapters;

import com.banco.main.domain.Cliente;
import com.banco.main.domain.Conta;
import com.banco.main.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaAdapter {
    @Autowired
    ContaRepository contaRepository;

    public Conta saveConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Cliente findByDocumento(String documento) {
        return contaRepository.findByDocumento(documento);
    }

    public Conta findByNumeroConta(Integer numeroConta) {
        return contaRepository.findByNumeroConta(numeroConta);
    }
}
