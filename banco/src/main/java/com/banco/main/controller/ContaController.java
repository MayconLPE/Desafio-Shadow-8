package com.banco.main.controller;


import com.banco.main.domain.Conta;
import com.banco.main.service.ContaService;
import com.banco.main.useCases.dtos.*;
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
    public ResponseEntity<?> ativarConta(@PathVariable Integer numeroConta) {
        return contaService.updateStatusContaAtivo(numeroConta);
    }
    @PatchMapping(value = "bloquear/{numeroConta}") // Mudar statusConta para BLOQUEADO.
    public ResponseEntity<?> bloquearConta(@PathVariable Integer numeroConta) {
        return contaService.updateStatusContaBloqueado(numeroConta);
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
    public ResponseEntity<?> pix(@RequestBody TransferenciaRequestDTO transferenciaRequestDTO) {
//        TransferenciaResponseDTO pixDto = contaService.pix(transferenciaRequestDTO);
        return contaService.pix(transferenciaRequestDTO);
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

//    @PostMapping(value = "/kafka")
//    public ResponseEntity<String> salvarDeposito(@RequestBody DepositoData depositoData) {
//        registrarEventoService.adicionarEvento("SalvarDeposito", depositoData);
//        return ResponseEntity.ok("Sucesso");
//    }


}