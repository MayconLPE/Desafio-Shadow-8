package com.banco.Main.service;


import com.banco.Main.domain.Conta;
import com.banco.Main.useCases.dtos.CriarNovaContaDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ContaService {

    Conta save(Conta conta);

    Conta gerarNovaConta(CriarNovaContaDto criarNovaContaDto);
    @Modifying
    @Query("update Conta c set c.saldo = c.saldo + ?1 where c.id = ?2")
    void setFixedSaldoFor(Double valor, String id);


    void depositar(Double valor, String id);

    Optional<Conta> findById(String id);

    Object findAll();
}
