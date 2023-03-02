package com.banco.Main.useCases.adapters;

import com.banco.Main.domain.Conta;
import com.banco.Main.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaAdapter {
    @Autowired
    ContaRepository contaRepository;

    public Conta saveConta(Conta conta) {
        return contaRepository.save(conta);
    }
}
