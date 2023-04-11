package com.banco.main.controller;

import com.banco.main.service.ClienteService;
import com.banco.main.useCases.dtos.ClienteDto;
import com.banco.main.useCases.dtos.RetornaClienteContaDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
@Api(value = "API REST Banco Cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping(value = "/cadastrar") // Cadastrar Cliente
    @ApiOperation(value="Cadastra um Cliente com conta, e retorna o Cliente cadastrado")
    public ResponseEntity save(@RequestBody ClienteDto clienteDto) {
        RetornaClienteContaDto retornaClienteContaDto = clienteService.save(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(retornaClienteContaDto);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um cliente por ID")
    public ResponseEntity<Object> buscarID(@PathVariable String id) {
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }

}
