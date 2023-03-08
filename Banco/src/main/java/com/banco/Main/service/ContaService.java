package com.banco.Main.service;


import com.banco.Main.domain.Cliente;
import com.banco.Main.domain.Conta;
import com.banco.Main.useCases.dtos.CriarNovaContaDto;

import java.util.Optional;

public interface ContaService {

    Conta save(Conta conta);
    Conta gerarNovaConta(CriarNovaContaDto criarNovaContaDto);
    Conta findByNumeroConta(Integer numeroConta);



    void depositar(Double valor, String id);

    Optional<Conta> findById(String id);

    Object findAll();
}
