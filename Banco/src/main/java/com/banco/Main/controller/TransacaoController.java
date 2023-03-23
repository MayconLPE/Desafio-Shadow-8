package com.banco.Main.controller;

import com.banco.Main.domain.Transacao;
import com.banco.Main.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {
    @Autowired
    TransacaoService transacaoService;
    @GetMapping(value = "/exibirTransacoes") // Exibir todas as Transações
    public ResponseEntity<Page> findAllTrans(Pageable pageable) {
        Page<Transacao> trans = transacaoService.findAll(pageable);
        return ResponseEntity.ok().body(trans);

    }
    @GetMapping(value = "/{contaOrigem}")
    public ResponseEntity<List<Transacao>> findByNumeroConta(@PathVariable(value = "contaOrigem") String contaOrigem) {
        List<Transacao> transacao = transacaoService.findByContaOrigem(contaOrigem);
        return ResponseEntity.ok().body(transacao);
    }

//    @PostMapping(value = "/salvar")
//    public ResponseEntity<?> savarTransacao(@RequestBody Transacao trans) {
//        Transacao transacao = this.transacaoService.save(trans);
//        return new ResponseEntity<>(transacao, HttpStatus.OK);
//    }


}
