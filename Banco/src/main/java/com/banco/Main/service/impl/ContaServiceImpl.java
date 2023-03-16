package com.banco.Main.service.impl;

import com.banco.Main.domain.Conta;
import com.banco.Main.domain.Transacao;
import com.banco.Main.domain.infoConta.ContaStatus;
import com.banco.Main.domain.infoTransacao.TipoTransacao;
import com.banco.Main.repository.ContaRepository;
import com.banco.Main.service.ContaService;
import com.banco.Main.service.TransacaoService;
import com.banco.Main.useCases.adapters.ContaAdapter;
import com.banco.Main.useCases.dtos.*;
import com.banco.Main.useCases.util.GeradorContaUtil;
import com.banco.Main.useCases.util.GeradorTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService {
    @Autowired
    ContaRepository contaRepository;

    @Autowired
    TransacaoService transacaoService;
    @Autowired
    GeradorContaUtil geradorContaUtil;
    @Autowired
    ContaAdapter contaAdapter;


    @Override
    public Conta save(Conta conta) {
        return contaAdapter.saveConta(conta);
    }

    @Override
    public Conta gerarNovaConta(CriarNovaContaDto criarNovaContaDto) {
        var novaConta = geradorContaUtil.geradorContaNova(criarNovaContaDto);
        return save(novaConta);
    }
    @Override
    public Conta findByNumeroConta(Integer numeroConta) {
        return contaAdapter.findByNumeroConta(numeroConta);
    }
    @Override
    public Conta updateStatusContaAtivo(Integer numeroConta) {
        Conta c = findByNumeroConta(numeroConta);
        c.setContaStatus(ContaStatus.ATIVO);
        return contaRepository.save(c);
    }
    @Override
    public Conta updateStatusContaBloqueado(Integer numeroConta) {
        Conta c = findByNumeroConta(numeroConta);
        c.setContaStatus(ContaStatus.BLOQUEADO);
        return contaRepository.save(c);
    }
    @Override
    public Page<Conta> findAll(Pageable pageable) {
        return contaRepository.findAll(pageable);
    }

    @Override
    public DepositoResponseDto deposito(DepositoRequestDto depositoRequestDto) {

        var responseDto = new DepositoResponseDto();
        Conta conta = findByNumeroConta(depositoRequestDto.getNumeroConta());

        Transacao transacao = GeradorTransacao.deposito(conta.getId(), TipoTransacao.DEPOSITO, depositoRequestDto.getValorDeposito(), conta.getSaldo());
        transacao.setContaDestino(conta.getId()); // id da conta conta destino
        responseDto.setSaldoAntigo(conta.getSaldo()); // respostas saldo antigo

        conta.setSaldo(conta.getSaldo() + depositoRequestDto.getValorDeposito()); // depositando valor no saldo
        responseDto.setSaldoAtual(conta.getSaldo()); // resposta saldo atual
        transacao.setSaldoAtual(conta.getSaldo()); // salvando em transações

        contaRepository.save(conta);
        transacaoService.save(transacao);

        responseDto.setData(depositoRequestDto.getData());
        responseDto.setNumeroConta(depositoRequestDto.getNumeroConta());
        responseDto.setDigito(depositoRequestDto.getDigito());
        responseDto.setAgencia(depositoRequestDto.getAgencia());
        responseDto.setValorDeposito(depositoRequestDto.getValorDeposito());

        return responseDto;
    }
    @Override
    public SaqueResponseDto saque(SaqueRequestDto saqueRequestDto) {

        var responseDto = new SaqueResponseDto();
        Conta conta = findByNumeroConta(saqueRequestDto.getNumeroConta());

        conta.setSaldo(conta.getSaldo() - saqueRequestDto.getValorSaque());

        Transacao transacao = GeradorTransacao.saque(conta.getId(), TipoTransacao.SAQUE, saqueRequestDto.getValorSaque(), conta.getSaldo());
        transacao.setContaDestino(conta.getId());
        responseDto.setSaldoAntigo(conta.getSaldo());

        conta.setSaldo(conta.getSaldo() + saqueRequestDto.getValorSaque());
        responseDto.setSaldoAtual(conta.getSaldo());
        transacao.setSaldoAtual(conta.getSaldo());

        contaRepository.save(conta);
        transacaoService.save(transacao);

        responseDto.setData(saqueRequestDto.getData());
        responseDto.setNumeroConta(saqueRequestDto.getNumeroConta());
        responseDto.setDigito(saqueRequestDto.getDigito());
        responseDto.setAgencia(saqueRequestDto.getAgencia());
        responseDto.setValorSaque(saqueRequestDto.getValorSaque());

        return responseDto;
    }


    

//    @Override
//    public TransferenciaDTO pix(TransferenciaDTO transferenciaDTO) {
//        Conta contaOrigem = findByNumeroConta(transferenciaDTO.getContaOrigem());
//        Conta contaDestino = findByNumeroConta(transferenciaDTO.getContaDestino());
//
//        contaRepository.alterSaldoConta(contaOrigem.getNumeroConta(),contaOrigem.getSaldo() - transferenciaDTO.getValor());
//        contaRepository.alterSaldoConta(contaDestino.getNumeroConta(), contaDestino.getSaldo() + transferenciaDTO.getValor());
//
//        return null;
//    }



    @Override
    public Optional<Conta> findById(String id) {
        var res = contaRepository.findById(id);
        return contaRepository.findById(id);
    }







}
