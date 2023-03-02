package com.banco.Main.service;

import com.banco.Main.domain.Conta;
import com.banco.Main.domain.infoConta.ContaStatus;
import com.banco.Main.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    @Autowired
    ContaRepository contaRepository;

    public Conta save(Conta conta) {
        conta.setContaStatus(ContaStatus.PENDENTE);
        return contaRepository.save(conta);
    }




    public Object findAll() {
        return contaRepository.findAll();
    }
}
