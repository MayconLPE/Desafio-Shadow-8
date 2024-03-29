package com.banco.main.useCases.util;

import com.banco.main.domain.Transacao;
import com.banco.main.domain.infoTransacao.TipoTransacao;

import java.time.LocalDateTime;

public class GeradorTransacao {

    public static Transacao deposito(String id, TipoTransacao tipoTransacao, Double valor, Double saldoAtual) {

        LocalDateTime data = LocalDateTime.now();
        Transacao deposito = new Transacao();
        deposito.setId(id);
        deposito.setTipoTransacao(tipoTransacao);
        deposito.setValorTransacao(valor);
        deposito.setDataTransacao(data);
        deposito.setSaldoAntigo(saldoAtual);

        return deposito;
    }
    public static Transacao saque(String id, TipoTransacao tipoTransacao, Double valor, Double saldoAtual) {

        LocalDateTime data = LocalDateTime.now();
        Transacao saque = new Transacao();
        saque.setId(id);
        saque.setTipoTransacao(tipoTransacao);
        saque.setValorTransacao(valor);
        saque.setDataTransacao(data);
        saque.setSaldoAntigo(saldoAtual);

        return saque;
    }
    public static Transacao gerarPixDocTed(String id, TipoTransacao tipoTransacao, Double valor, Double saldoAtual) {

        LocalDateTime data = LocalDateTime.now();
        Transacao pix = new Transacao();
        pix.setId(id);
        pix.setTipoTransacao(tipoTransacao);
        pix.setValorTransacao(valor);
        pix.setDataTransacao(data);
        pix.setSaldoAntigo(saldoAtual);

        return pix;
    }

}
