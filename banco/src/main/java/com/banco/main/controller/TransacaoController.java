package com.banco.main.controller;

import com.banco.main.domain.Transacao;
import com.banco.main.domain.infoTransacao.TipoTransacao;
import com.banco.main.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {
    @Autowired
    TransacaoService transacaoService;
    @GetMapping(value = "/exibirTransacoes") // Exibir todas as Transações.
    public ResponseEntity<Page> findAllTrans(Pageable pageable) {
        Page<Transacao> trans = transacaoService.findAll(pageable);
        return ResponseEntity.ok().body(trans);
    }
    @GetMapping(value = "/extrato") // Extrato por conta e tipoTransacao.
    public ResponseEntity<Page<Transacao>> extrato(@RequestParam String contaOrigem,
                                                   @RequestParam(required = false) TipoTransacao tipoTransacao, Pageable pageable) {
        if (tipoTransacao == null) {
            Page<Transacao> transacao = transacaoService.extratoContaOrigem(contaOrigem, pageable);
            return ResponseEntity.ok().body(transacao);
        }
        Page<Transacao> transacao = transacaoService.extratoContaOrigemAndTipoTransacao(contaOrigem, tipoTransacao,pageable);
        return ResponseEntity.ok().body(transacao);
    }
}