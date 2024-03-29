package com.banco.main.service;


import com.banco.main.domain.Conta;
import com.banco.main.useCases.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ContaService {

    Conta save(Conta conta);
    Conta gerarNovaConta(CriarNovaContaDto criarNovaContaDto);
    Conta findByNumeroConta(Integer numeroConta);
    ResponseEntity<?> updateStatusContaAtivo(Integer numeroConta);
    ResponseEntity<?> updateStatusContaBloqueado(Integer numeroConta);
    Page<Conta> findAll(Pageable pageable);
    ResponseEntity<?> deposito(DepositoRequestDto depositoRequestDto);
    ResponseEntity<?> saque(SaqueRequestDto saqueRequestDto);
    ResponseEntity<?> pix(TransferenciaRequestDTO transferenciaRequestDTO);
    TransferenciaResponseDTO doc(TransferenciaRequestDTO transferenciaRequestDTO);
    TransferenciaResponseDTO ted(TransferenciaRequestDTO transferenciaRequestDTO);

    Optional<Conta> findById(String id);
}
