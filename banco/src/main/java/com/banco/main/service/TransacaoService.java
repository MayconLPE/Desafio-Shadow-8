package com.banco.main.service;

import com.banco.main.domain.Transacao;
import com.banco.main.domain.infoTransacao.TipoTransacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransacaoService {

    Transacao save(Transacao transacao);
    Page<Transacao> findAll(Pageable pageable);
    Page<Transacao> extratoContaOrigem(String contaOrigem, Pageable pageable);
    Page<Transacao> extratoContaOrigemAndTipoTransacao(String contaOrigem, TipoTransacao tipoTransacao, Pageable pageable);


}
