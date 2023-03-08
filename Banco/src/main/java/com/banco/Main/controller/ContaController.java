package com.banco.Main.controller;

import com.banco.Main.domain.Cliente;
import com.banco.Main.domain.Conta;
import com.banco.Main.service.ContaService;
import com.banco.Main.useCases.dtos.CriarNovaContaDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/{numeroConta}")
    public ResponseEntity<Object> buscarNumeroConta(@PathVariable Integer numeroConta) {
        return new ResponseEntity<>(contaService.findByNumeroConta(numeroConta), HttpStatus.OK);
    }

    @PutMapping(value = "/depositar/{valor}/{id}")
    public ResponseEntity<?> depositar(@PathVariable Double valor,@PathVariable String id) {
        this.contaService.depositar(valor, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @GetMapping(value = "saldo/{id}")
//    public ResponseEntity<?> saldo(@PathVariable String id){
//        Conta c = contaService.findById(id);
//        return new ResponseEntity<>(c.getSaldo(), HttpStatus.OK);
//
//    }


}
