package com.banco.Main.useCases.util;

import com.banco.Main.domain.Cliente;
import com.banco.Main.domain.Conta;
import com.banco.Main.domain.infoConta.ContaStatus;
import com.banco.Main.domain.infoConta.NomeBanco;
import com.banco.Main.useCases.dtos.CriarNovaContaDto;
import org.springframework.stereotype.Component;

@Component
public class GeradorContaUtil {

    Integer agencia = 12345;

    int min = 100000;
    int max = 500000;

    int numeroContaRandom = (int) Math.floor((Math.random()) * (max - min + 1) + min);

    public Conta gerarContaInit(Cliente cliente) {

        Conta conta = new Conta();
        conta.setIdCliente(cliente.getId());
        conta.setDocumento(cliente.getDocumento());
        conta.setContaStatus(ContaStatus.PENDENTE);
        conta.setNomeBanco(NomeBanco.BANCOPE);
        conta.setTipoConta(cliente.getTipoConta());
        conta.setAgencia(agencia);
        conta.setNumeroConta(numeroContaRandom);
        conta.setDigito(1);
        return conta;
    }

//    public Conta geradorContaNova(CriarNovaContaDto criarNovaContaDto) {
//
//        Conta conta = new Conta();
//        return conta;
//
//    }
}
