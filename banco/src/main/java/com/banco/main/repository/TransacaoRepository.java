package com.banco.main.repository;

import com.banco.main.domain.Transacao;
import com.banco.main.domain.infoTransacao.TipoTransacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {

    Page<Transacao> findByContaOrigem(String contaOrigem, Pageable pageable);
    Page<Transacao> findByContaOrigemAndTipoTransacao(String contaOrigem, TipoTransacao tipoTransacao, Pageable pageable); // buscar id da contaOrigem



}
