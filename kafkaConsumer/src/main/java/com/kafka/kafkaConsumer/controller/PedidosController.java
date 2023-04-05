package com.kafka.kafkaConsumer.controller;

import com.kafka.kafkaConsumer.data.PedidoData;
import com.kafka.kafkaConsumer.services.RegistrarEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/conta")
public class PedidosController {
    @Autowired
    RegistrarEventoService registrarEventoService;
//    @PostMapping(value = "/kafka")
//    public ResponseEntity<String> salvarPedido(@RequestBody PedidoData pedido) {
//        registrarEventoService.adicionarEvento("SalvarPedido", pedido);
//        return ResponseEntity.ok("Sucesso");
//    }
}
