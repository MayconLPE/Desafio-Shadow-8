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
    public DepositoResponseDto deposito(DepositoDto depositoDto) {

        var responseDto = new DepositoResponseDto();
        Conta conta = findByNumeroConta(depositoDto.getNumeroConta());

        responseDto.setSaldoAntigo(conta.getSaldo());
        Transacao transacao = GeradorTransacao.deposito(conta.getId(), TipoTransacao.DEPOSITO,depositoDto.getValorDeposito(), conta.getSaldo());
        transacao.setContaDestino(conta.getId());
        conta.setSaldo(conta.getSaldo() + depositoDto.getValorDeposito());
        responseDto.setSaldoAtual(conta.getSaldo());
        transacao.setSaldoAtual(conta.getSaldo());

        contaRepository.save(conta);
        transacaoService.save(transacao);

        responseDto.setData(depositoDto.getData());
        responseDto.setNumeroConta(depositoDto.getNumeroConta());
        responseDto.setDigito(depositoDto.getDigito());
        responseDto.setAgencia(depositoDto.getAgencia());
        responseDto.setValorDeposito(depositoDto.getValorDeposito());

        return responseDto;

    }


    @Override
    public SaqueDto saque(SaqueDto saqueDto) {

        Conta conta = findByNumeroConta(saqueDto.getNumeroConta());

        conta.setSaldo(conta.getSaldo() - saqueDto.getValor());

        Transacao transacao = GeradorTransacao.saque(conta.getId(), TipoTransacao.SAQUE,saqueDto.getValor());
        transacao.setContaDestino(conta.getId());
        transacao.setSaldoAtual(conta.getSaldo());


        contaRepository.save(conta);
        return saqueDto;
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
