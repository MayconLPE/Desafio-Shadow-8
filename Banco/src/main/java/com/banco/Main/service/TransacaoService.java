package com.banco.Main.service;

import com.banco.Main.domain.Transacao;
import com.banco.Main.domain.infoTransacao.TipoTransacao;
import com.banco.Main.useCases.dtos.TransferenciaResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransacaoService {

    Transacao save(Transacao transacao);
    Page<Transacao> findAll(Pageable pageable);
    Page<Transacao> findByContaOrigem(String contaOrigem, TipoTransacao tipoTransacao, Pageable pageable);


}
