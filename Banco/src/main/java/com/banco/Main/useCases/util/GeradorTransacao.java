package com.banco.Main.useCases.util;

import com.banco.Main.domain.Transacao;
import com.banco.Main.domain.infoTransacao.TipoTransacao;

import java.time.LocalDateTime;

public class GeradorTransacao {

    public static Transacao gerar(String id, TipoTransacao tipoTransacao, Double valor) {
        LocalDateTime data = LocalDateTime.now();
        Transacao transacao = new Transacao();
        transacao.setId(id);
        transacao.setTipoTransacao(tipoTransacao);
        transacao.setValor(valor);
        transacao.setDataTransacao(data);
        return transacao;
    }

}
