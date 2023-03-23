package com.banco.Main.repository;

import com.banco.Main.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {

    List<Transacao> findByContaOrigem(String contaOrigem); // buscar numero da contaOrigem

//    Page<Transacao> findByNumeroContaTipoTransacao(Integer contaOrigem, TipoTransacao tipoTransacao, Pageable pageable);
//    Page<Transacao> findByIdConta(String id, Pageable pageable);
//    Page<Transacao> findByIdContaTipoTransacao(String id, TipoTransacao tipoTransacao, Pageable pageable);

}
