package com.banco.main.service.impl;

import com.banco.main.domain.Transacao;
import com.banco.main.domain.infoTransacao.TipoTransacao;
import com.banco.main.repository.TransacaoRepository;
import com.banco.main.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransacaoServiceImpl implements TransacaoService {
    @Autowired
    TransacaoRepository transacaoRepository;


    @Override
    public Transacao save(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }
    @Override
    public Page<Transacao> findAll(Pageable pageable) {
        return transacaoRepository.findAll(pageable);
    }

    @Override
    public Page<Transacao> extratoContaOrigem(String contaOrigem, Pageable pageable) {
        return transacaoRepository.findByContaOrigem(contaOrigem, pageable);
    }

    @Override
    public Page<Transacao> extratoContaOrigemAndTipoTransacao(String contaOrigem, TipoTransacao tipoTransacao, Pageable pageable) {
        return transacaoRepository.findByContaOrigemAndTipoTransacao(contaOrigem, tipoTransacao, pageable);
    }



}
