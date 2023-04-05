package com.banco.Main.service.impl;

import com.banco.Main.domain.Transacao;
import com.banco.Main.domain.infoTransacao.TipoTransacao;
import com.banco.Main.repository.TransacaoRepository;
import com.banco.Main.service.TransacaoService;
import com.banco.Main.useCases.dtos.TransferenciaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Page<Transacao> findByContaOrigem(String contaOrigem, TipoTransacao tipoTransacao, Pageable pageable) {
        return transacaoRepository.findByContaOrigemAndTipoTransacao(contaOrigem, tipoTransacao, pageable);
    }



}
