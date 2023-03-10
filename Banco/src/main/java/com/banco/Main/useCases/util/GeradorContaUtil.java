package com.banco.Main.useCases.util;

import com.banco.Main.domain.Cliente;
import com.banco.Main.domain.Conta;
import com.banco.Main.domain.infoConta.ContaStatus;
import com.banco.Main.domain.infoConta.NomeBanco;
import com.banco.Main.useCases.dtos.CriarNovaContaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeradorContaUtil {
    @Autowired
    PegarIdClienteUtil pegarIdClienteUtil;

    Integer agencia = 12345;
    int min = 100000;
    int max = 500000;

    public Conta gerarContaInit(Cliente cliente) {
        int numeroContaRandom = (int) Math.floor((Math.random()) * (max - min + 1) + min);

        var conta = Conta.builder()
                .idCliente(cliente.getId())
                .nomeCliente(cliente.getNome())
                .documento(cliente.getDocumento())
                .contaStatus(ContaStatus.PENDENTE)
                .tipoConta(cliente.getTipoConta())
                .agencia(agencia)
                .numeroConta(numeroContaRandom)
                .digito(1)
                .saldo(50.0)
                .build();
        return conta;
    }
    public Conta geradorContaNova(CriarNovaContaDto criarNovaContaDto) {
        int numeroContaRandom = (int) Math.floor((Math.random()) * (max - min + 1) + min);

        var idCliente = pegarIdClienteUtil.buscarId(criarNovaContaDto.getIdCliente()); // pegar Idcliente

        var conta = Conta.builder()
                .idCliente(idCliente.get().getId())
                .nomeCliente(idCliente.get().getNome())
                .documento(criarNovaContaDto.getDocumento())
                .contaStatus(ContaStatus.PENDENTE)
                .tipoConta(criarNovaContaDto.getTipoConta())
                .agencia(agencia)
                .numeroConta(numeroContaRandom)
                .digito(2)
                .saldo(0.0)
                .build();
        return conta;

    }
}
