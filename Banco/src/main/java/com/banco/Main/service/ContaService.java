package com.banco.Main.service;


import com.banco.Main.domain.Conta;
import com.banco.Main.useCases.dtos.CriarNovaContaDto;
import com.banco.Main.useCases.dtos.SaldoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ContaService {

    Conta save(Conta conta);
    Conta gerarNovaConta(CriarNovaContaDto criarNovaContaDto);
    Conta findByNumeroConta(Integer numeroConta);
    Conta updateStatusContaAtivo(Integer numeroConta);
    Conta updateStatusContaBloqueado(Integer numeroConta);
    Page<Conta> findAll(Pageable pageable);




//    Optional<Conta> saldoConta(Integer numeroConta);

    void depositar(Double valor, String id);

    Optional<Conta> findById(String id);

}
