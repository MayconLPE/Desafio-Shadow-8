package com.banco.Main.controller;

import com.banco.Main.domain.Cliente;
import com.banco.Main.domain.Conta;
import com.banco.Main.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/conta")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<Object> save(@RequestBody Conta conta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.save(conta));
    }

    @PostMapping(value = "/salvar2")
    public ResponseEntity<Object> save2(@RequestBody Conta conta) {
        conta = contaService.save(conta);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(conta.getId())
                .toUri();
        return ResponseEntity.created(uri).body(conta);
    }
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(contaService.findAll());
    }
}
