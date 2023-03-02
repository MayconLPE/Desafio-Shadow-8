package com.banco.Main.service.impl;

import com.banco.Main.domain.Conta;
import com.banco.Main.repository.ContaRepository;
import com.banco.Main.service.ContaService;
import com.banco.Main.useCases.adapters.ContaAdapter;
import com.banco.Main.useCases.dtos.CriarNovaContaDto;
import com.banco.Main.useCases.util.GeradorContaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService {
    @Autowired
    ContaRepository contaRepository;
    @Autowired
    GeradorContaUtil geradorContaUtil;
    @Autowired
    ContaAdapter contaAdapter;

    public Conta save(Conta conta) {
        return contaAdapter.saveConta(conta);
    }

    public Conta gerarNovaConta(CriarNovaContaDto criarNovaContaDto) {
        var novaConta = geradorContaUtil.geradorContaNova(criarNovaContaDto);
        return save(novaConta);
    }

    @Override
    public Optional<Conta> findById(String id) {
        return Optional.empty();
    }


    public Object findAll() {
        return contaRepository.findAll();
    }

}
