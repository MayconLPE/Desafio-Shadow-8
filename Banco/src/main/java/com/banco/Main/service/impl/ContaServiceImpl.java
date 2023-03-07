package com.banco.Main.service.impl;

import com.banco.Main.domain.Conta;
import com.banco.Main.repository.ContaRepository;
import com.banco.Main.service.ContaService;
import com.banco.Main.service.TransacaoService;
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
    TransacaoService transacaoService;
    @Autowired
    GeradorContaUtil geradorContaUtil;
    @Autowired
    ContaAdapter contaAdapter;

    @Override
    public Conta save(Conta conta) {
        return contaAdapter.saveConta(conta);
    }

    @Override
    public Conta gerarNovaConta(CriarNovaContaDto criarNovaContaDto) {
        var novaConta = geradorContaUtil.geradorContaNova(criarNovaContaDto);
        return save(novaConta);
    }

    @Override
    public void setFixedSaldoFor(Double valor, String id) {

    }

    @Override
    public void depositar(Double valor, String id) {
        contaRepository.setFixedSaldoFor(valor, id);
    }

    @Override
    public Optional<Conta> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Object findAll() {
        return contaRepository.findAll();
    }



}
