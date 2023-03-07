package com.banco.Main.controller;

import com.banco.Main.domain.Transacao;
import com.banco.Main.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {
    @Autowired
    TransacaoService transacaoService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<?> savarTransacao(@RequestBody Transacao trans) {

        Transacao transacao = this.transacaoService.save(trans);
        return new ResponseEntity<>(transacao, HttpStatus.OK);
    }


}
