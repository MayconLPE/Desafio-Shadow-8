package com.banco.Main.service;


import com.banco.Main.domain.Conta;
import com.banco.Main.domain.Transacao;
import com.banco.Main.domain.infoTransacao.TipoTransacao;
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


//    Page<ExtratoResponseDto> extratoNumeroConta(Integer numeroConta, Integer digito, Integer agencia, Pageable pageable);
//    Page<ExtratoResponseDto> extratoNumeroContaTipoTransacao(Integer numeroConta, Integer digito, Integer agencia, TipoTransacao tipoTransacao, Pageable pageable);
//    Page<ExtratoResponseDto> findByIdContaTipoTransacao(String id, TipoTransacao tipoTransacao, Pageable pageable);

    Optional<Conta> findById(String id);
}
