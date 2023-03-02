package com.banco.Main.service;


import com.banco.Main.domain.Conta;
import com.banco.Main.useCases.dtos.CriarNovaContaDto;

import java.util.Optional;

public interface ContaService {

    Conta save(Conta conta);

    Conta gerarNovaConta(CriarNovaContaDto criarNovaContaDto);

    Optional<Conta> findById(String id);



}
