package com.banco.Main.service;

import com.banco.Main.domain.Conta;
import com.banco.Main.domain.Transacao;
import org.springframework.data.domain.Pageable;

public interface TransacaoService {
    Transacao save(Transacao transacao);



}
