package com.banco.Main.controller;

import com.banco.Main.domain.Transacao;
import com.banco.Main.domain.infoTransacao.TipoTransacao;
import com.banco.Main.service.TransacaoService;
import com.banco.Main.useCases.dtos.TransferenciaResponseDTO;
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