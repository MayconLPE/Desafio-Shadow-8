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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public ResponseEntity<?> deposito(DepositoRequestDto depositoRequestDto) {

        var responseDto = new DepositoResponseDto();
        Conta conta = findByNumeroConta(depositoRequestDto.getNumeroConta());

        if (!conta.getContaStatus().equals(ContaStatus.ATIVO) ) {
            return new ResponseEntity<>("Conta não Ativa", HttpStatus.PRECONDITION_FAILED);
        }

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

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> saque(SaqueRequestDto saqueRequestDto) {
        var responseDto = new SaqueResponseDto();
        Conta conta = findByNumeroConta(saqueRequestDto.getNumeroConta());

        if (!conta.getContaStatus().equals(ContaStatus.ATIVO) ) {
            return new ResponseEntity<>("Conta não Ativa", HttpStatus.PRECONDITION_FAILED);
        }

        conta.setSaldo(conta.getSaldo() - saqueRequestDto.getValorSaque());

        Transacao transacao = GeradorTransacao.saque(conta.getId(), TipoTransacao.SAQUE, saqueRequestDto.getValorSaque(), conta.getSaldo());
        transacao.setContaDestino(conta.getId());
        responseDto.setSaldoAntigo(conta.getSaldo());

        conta.setSaldo(conta.getSaldo() - saqueRequestDto.getValorSaque());
        responseDto.setSaldoAtual(conta.getSaldo());
        transacao.setSaldoAtual(conta.getSaldo());

        contaRepository.save(conta); 
        transacaoService.save(transacao);

        responseDto.setData(saqueRequestDto.getData());
        responseDto.setNumeroConta(saqueRequestDto.getNumeroConta());
        responseDto.setDigito(saqueRequestDto.getDigito());
        responseDto.setAgencia(saqueRequestDto.getAgencia());
        responseDto.setValorSaque(saqueRequestDto.getValorSaque());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @Override
    public TransferenciaResponseDTO pix(TransferenciaRequestDTO transferenciaRequestDTO) {
        var responseDto = new TransferenciaResponseDTO();
        Conta contaOringem = findByNumeroConta(transferenciaRequestDTO.getContaOrigem());
        Conta contaDestino = findByNumeroConta(transferenciaRequestDTO.getContaDestino());


        Transacao transacao = GeradorTransacao.pix(contaDestino.getId(), TipoTransacao.PIX, transferenciaRequestDTO.getValor(), contaOringem.getSaldo());
        transacao.setContaDestino(contaDestino.getId());
        transacao.setContaOrigem(contaOringem.getId());
        responseDto.setSaldoAntigo(contaOringem.getSaldo());

        contaOringem.setSaldo(contaOringem.getSaldo() - transferenciaRequestDTO.getValor());
        contaDestino.setSaldo(contaDestino.getSaldo() + transferenciaRequestDTO.getValor());
        responseDto.setSaldoAtual(contaOringem.getSaldo());
        transacao.setSaldoAtual(contaOringem.getSaldo());

        contaRepository.save(contaDestino);
        contaRepository.save(contaOringem);
        transacaoService.save(transacao);

        responseDto.setDataTransacao(transferenciaRequestDTO.getDataTransacao());
        responseDto.setContaOrigem(transferenciaRequestDTO.getContaOrigem());
        responseDto.setContaDestino(transferenciaRequestDTO.getContaDestino());
        responseDto.setValor(transferenciaRequestDTO.getValor());

        return responseDto;
    }

    @Override
    public Page<ExtratoResponseDto> extrato(Integer numeroConta, Pageable pageable) {
        return null;
    }


    @Override
    public Optional<Conta> findById(String id) {
        var res = contaRepository.findById(id);
        return contaRepository.findById(id);
    }







}
