package com.banco.Main.repository;

import com.banco.Main.domain.Transacao;
import com.banco.Main.domain.infoTransacao.TipoTransacao;
import com.banco.Main.useCases.dtos.TransferenciaResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {

    Page<Transacao> findByContaOrigemAndTipoTransacao(String contaOrigem, TipoTransacao tipoTransacao, Pageable pageable); // buscar id da contaOrigem



}
