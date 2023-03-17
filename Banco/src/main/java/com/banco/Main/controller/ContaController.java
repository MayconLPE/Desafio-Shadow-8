package com.banco.Main.controller;

import com.banco.Main.domain.Conta;
import com.banco.Main.service.ContaService;
import com.banco.Main.useCases.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/conta")
public class ContaController {
    @Autowired
    ContaService contaService;

    @PostMapping(value = "/novaConta") // Adicionar uma nova conta a cliente ja criado.
    public ResponseEntity novaConta(@RequestBody CriarNovaContaDto criarNovaContaDto) {
        var conta = contaService.gerarNovaConta(criarNovaContaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }
    @GetMapping(value = "/{numeroConta}") // buscar por numero da conta
    public ResponseEntity<Conta> buscarNumeroConta(@PathVariable Integer numeroConta) {
        return new ResponseEntity<>(contaService.findByNumeroConta(numeroConta), HttpStatus.OK);
    }
    @PatchMapping(value = "ativar/{numeroConta}") // Mudar statusConta para ATIVO.
    public ResponseEntity<Conta> ativarConta(@PathVariable Integer numeroConta) {
        return new ResponseEntity<>(contaService.updateStatusContaAtivo(numeroConta), HttpStatus.OK);
    }
    @PatchMapping(value = "bloquear/{numeroConta}") // Mudar statusConta para BLOQUEADO.
    public ResponseEntity<Conta> bloquearConta(@PathVariable Integer numeroConta) {
        return new ResponseEntity<>(contaService.updateStatusContaBloqueado(numeroConta), HttpStatus.OK);
    }
    @GetMapping(value = "/exibirContas") // Exibir todas as contas
    public ResponseEntity<Page> findAll(Pageable pageable) {
        Page<Conta> contas = contaService.findAll(pageable);
        return ResponseEntity.ok().body(contas);
    }
    @GetMapping(value =  "/saldo/{numeroConta}") // Exibir Saldo da conta
    public SaldoDto saldoConta(@PathVariable Integer numeroConta) {
        return new SaldoDto(contaService.findByNumeroConta(numeroConta));
    }
    @PostMapping(value = "/depositar")
    public ResponseEntity<?> depositar(@RequestBody DepositoRequestDto depositoRequestDto) {
        return contaService.deposito(depositoRequestDto);
    }
    @PostMapping(value = "/sacar")
    public ResponseEntity<SaqueResponseDto> sacar(@RequestBody SaqueRequestDto saqueRequestDto) {
        SaqueResponseDto saqueDto = contaService.saque(saqueRequestDto);
        return  ResponseEntity.status(HttpStatus.OK).body(saqueDto);
    }
    @PostMapping(value = "/pix")
    public ResponseEntity<TransferenciaResponseDTO> pix(@RequestBody TransferenciaRequestDTO transferenciaRequestDTO) {
        TransferenciaResponseDTO pixDto = contaService.pix(transferenciaRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(pixDto);
    }

}
