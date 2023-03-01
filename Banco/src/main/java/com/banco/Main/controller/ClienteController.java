package com.banco.Main.controller;

import com.banco.Main.domain.Cliente;
import com.banco.Main.service.ClienteService;
import com.banco.Main.useCases.dtos.ClienteDto;
import com.banco.Main.useCases.dtos.RetornaClienteContaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @PostMapping(value = "/cadastrar") // Cadastrar Cliente
    public ResponseEntity save(@RequestBody ClienteDto clienteDto) {
        RetornaClienteContaDto retornaClienteContaDto = clienteService.save(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(retornaClienteContaDto);

    }

//    @PostMapping(value = "/cadastrar") // Cadastrar Cliente
//    public ResponseEntity<Object> save(@RequestBody Cliente cliente) {
//
//        cliente.setRegistroCadastro(LocalDateTime.now());
//
//        cliente = clienteService.save(cliente);
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(cliente.getId())
//                .toUri();
//        return ResponseEntity.created(uri).body(cliente);
//    }

    @GetMapping(value = "/listar")
    public ResponseEntity<Object> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> buscarID(@PathVariable String id) {
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }

}
