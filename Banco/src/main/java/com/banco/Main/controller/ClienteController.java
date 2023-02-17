package com.banco.Main.controller;

import com.banco.Main.domain.Cliente;
import com.banco.Main.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<Object> save(@RequestBody Cliente cliente) {
        cliente.setRegistroCadastro(LocalDateTime.now()); // timezone
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @PostMapping(value = "/salvar2")
    public ResponseEntity<Object> save2(@RequestBody Cliente cliente) {
        cliente.setRegistroCadastro(LocalDateTime.now()); // timezone
        cliente = clienteService.save(cliente);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();
        return ResponseEntity.created(uri).body(cliente);
    }
    @GetMapping(value = "/listar")
    public ResponseEntity<Object> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

}
