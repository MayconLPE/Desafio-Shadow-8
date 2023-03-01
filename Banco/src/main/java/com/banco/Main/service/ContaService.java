package com.banco.Main.service;

import com.banco.Main.domain.Cliente;
import com.banco.Main.domain.Conta;
import com.banco.Main.domain.infoConta.ContaStatus;
import com.banco.Main.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
