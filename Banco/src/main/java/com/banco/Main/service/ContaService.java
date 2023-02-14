package com.banco.Main.service;

import com.banco.Main.domain.Conta;
import com.banco.Main.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta save(Conta conta) {
        return contaRepository.save(conta);
    }

    public Object findAll() {
        return contaRepository.findAll();
    }
}
