package com.banco.Main.service.impl;

import com.banco.Main.domain.Conta;
import com.banco.Main.domain.infoConta.ContaStatus;
import com.banco.Main.repository.ContaRepository;
import com.banco.Main.service.ContaService;
import com.banco.Main.service.TransacaoService;
import com.banco.Main.useCases.adapters.ContaAdapter;
import com.banco.Main.useCases.dtos.CriarNovaContaDto;
import com.banco.Main.useCases.dtos.SaldoDto;
import com.banco.Main.useCases.util.GeradorContaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public Conta findByNumeroConta(Integer numeroConta) {
        return contaAdapter.findByNumeroConta(numeroConta).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND," Numero conta não encontrado"));
    }
    @Override
    public Conta updateStatusContaAtivo(Integer numeroConta) {
        Conta c = findByNumeroConta(numeroConta);
        c.setContaStatus(ContaStatus.ATIVO);
        return contaRepository.save(c);
    }
    @Override
    public Conta updateStatusContaBloqueado(Integer numeroConta) {
        Conta c = findByNumeroConta(numeroConta);
        c.setContaStatus(ContaStatus.BLOQUEADO);
        return contaRepository.save(c);
    }
    @Override
    public Page<Conta> findAll(Pageable pageable) {
        return contaRepository.findAll(pageable);
    }

//    @Override
//    public Conta gerarNovaConta(CriarNovaContaDto criarNovaContaDto) {
//        var novaConta = geradorContaUtil.geradorContaNova(criarNovaContaDto);
//        return save(novaConta);
//    }




    @Override
    public void depositar(Double valor, String id) {

    }

    @Override
    public Optional<Conta> findById(String id) {
        return Optional.empty();
    }







}
