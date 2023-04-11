package com.banco.main.controller;

import com.banco.main.dataKafkaTest.DataKafkaTest;
import com.banco.main.service.impl.RegistrarEventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestKafkaController {

    private final RegistrarEventoService registrarEventoService;

    @PostMapping(value = "/kafka")
    public ResponseEntity<String> salvarPedido(@RequestBody DataKafkaTest dataKafkaTest) {
        registrarEventoService.adicionarEvento("SalvarPedido", dataKafkaTest);
        return ResponseEntity.ok("Sucesso");
    }


}
