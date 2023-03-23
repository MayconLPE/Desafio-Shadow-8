package com.banco.Main.service;

import com.banco.Main.domain.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransacaoService {

    Transacao save(Transacao transacao);
    Page<Transacao> findAll(Pageable pageable);

    //
    //

    List<Transacao> findByContaOrigem(String contaOrigem);


//    Page<Transacao> findByNumeroContaTipoTransacao(Integer contaOrigem, TipoTransacao tipoTransacao, Pageable pageable);
//    Page<Transacao> findByIdConta(String id, Pageable pageable);
//    Page<Transacao> findByIdContaTipoTransacao(String id, TipoTransacao tipoTransacao, Pageable pageable);


}
