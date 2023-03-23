package com.banco.Main.controller;

import com.banco.Main.domain.Conta;
import com.banco.Main.domain.infoTransacao.TipoTransacao;
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
    public ResponseEntity<?> sacar(@RequestBody SaqueRequestDto saqueRequestDto) {
        return contaService.saque(saqueRequestDto);
    }
    @PostMapping(value = "/pix")
    public ResponseEntity<TransferenciaResponseDTO> pix(@RequestBody TransferenciaRequestDTO transferenciaRequestDTO) {
        TransferenciaResponseDTO pixDto = contaService.pix(transferenciaRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(pixDto);
    }
    @PostMapping(value = "/doc")
    public ResponseEntity<TransferenciaResponseDTO> doc(@RequestBody TransferenciaRequestDTO transferenciaRequestDTO) {
        TransferenciaResponseDTO docDto = contaService.doc(transferenciaRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(docDto);
    }
    @PostMapping(value = "/ted")
    public ResponseEntity<TransferenciaResponseDTO> ted(@RequestBody TransferenciaRequestDTO transferenciaRequestDTO) {
        TransferenciaResponseDTO tedDto = contaService.ted(transferenciaRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(tedDto);
    }





//    @GetMapping(value = "/extrato")
//    public ResponseEntity<Page<ExtratoResponseDto>> extrato(@RequestParam(name = "numeroConta") Integer numeroConta,
//                                                            @RequestParam(name = "digito") Integer digito,
//                                                            @RequestParam(name = "agencia") Integer agencia,
//                                                            @RequestParam(name = "filter", required = false) TipoTransacao tipoTransacao,
//                                                            Pageable pageable){
////        if (tipoTransacao == null) {
//            Page<ExtratoResponseDto> extrato = contaService.findByIdConta(agencia, numeroConta, digito,pageable);
//            return ResponseEntity.ok().body(extrato);
////        }
////        Page<ExtratoResponseDto> extrato = contaService.extratoNumeroContaTipoTransacao(numeroConta,digito,agencia,tipoTransacao,pageable);
////        return ResponseEntity.ok().body(extrato);
//    }






}