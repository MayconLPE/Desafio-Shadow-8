package com.banco.Main.useCases.util;

import com.banco.Main.domain.Conta;
import com.banco.Main.domain.infoConta.ContaStatus;
import com.banco.Main.useCases.adapters.ContaAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlterarStatusContaUtil {
    @Autowired
    ContaAdapter contaAdapter;

    public Conta contaStatusAtivo(Conta conta) {
        var numeroConta1 = conta.getNumeroConta();
        var res = contaAdapter.findByNumeroConta(numeroConta1);

        var statusAnterior = res.get().getContaStatus();
        var statusNovo = ContaStatus.ATIVO;
        res.get().setContaStatus(statusNovo);

       return conta;
    }
}
