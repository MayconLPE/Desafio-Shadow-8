package com.banco.Main.service;


import com.banco.Main.domain.Conta;
import com.banco.Main.useCases.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ContaService {

    Conta save(Conta conta);
    Conta gerarNovaConta(CriarNovaContaDto criarNovaContaDto);
    Conta findByNumeroConta(Integer numeroConta);
    Conta updateStatusContaAtivo(Integer numeroConta);
    Conta updateStatusContaBloqueado(Integer numeroConta);
    Page<Conta> findAll(Pageable pageable);
    ResponseEntity<?> deposito(DepositoRequestDto depositoRequestDto);
    ResponseEntity<?> saque(SaqueRequestDto saqueRequestDto);
    TransferenciaResponseDTO pix(TransferenciaRequestDTO transferenciaRequestDTO);

    // DOC

    // TED


    Page<ExtratoResponseDto> extrato(Integer numeroConta, Pageable pageable);

    Optional<Conta> findById(String id);

}
