package com.banco.main.service.impl;

import com.banco.main.domain.Conta;
import com.banco.main.domain.Transacao;
import com.banco.main.domain.infoConta.ContaStatus;
import com.banco.main.domain.infoTransacao.TipoTransacao;
import com.banco.main.repository.ContaRepository;
import com.banco.main.service.ContaService;
import com.banco.main.service.TransacaoService;
import com.banco.main.useCases.adapters.ContaAdapter;
import com.banco.main.useCases.dtos.*;
import com.banco.main.useCases.util.GeradorContaUtil;
import com.banco.main.useCases.util.GeradorTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public ResponseEntity<?> updateStatusContaAtivo(Integer numeroConta) {
        Conta c = findByNumeroConta(numeroConta);
        if (c.getContaStatus() == ContaStatus.ATIVO) {
            return new ResponseEntity<>("Conta já foi ATIVA", HttpStatus.PRECONDITION_FAILED);
        }
        c.setContaStatus(ContaStatus.ATIVO);
        return new ResponseEntity<>(contaRepository.save(c), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> updateStatusContaBloqueado(Integer numeroConta) {
        Conta c = findByNumeroConta(numeroConta);
        if (c.getContaStatus() == ContaStatus.BLOQUEADO) {
            return new ResponseEntity<>("Conta já foi BLOQUEADA", HttpStatus.PRECONDITION_FAILED);
        }
        c.setContaStatus(ContaStatus.BLOQUEADO);
        return new ResponseEntity<>(contaRepository.save(c), HttpStatus.OK);
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

        Transacao transacao = GeradorTransacao.deposito(conta.getIdConta(), TipoTransacao.DEPOSITO, depositoRequestDto.getValorDeposito(), conta.getSaldo());
        transacao.setContaDestino(conta.getIdConta()); // id da conta conta destino
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

        // Quantidade de saques:
        if (conta.getQuantidadeSaquesDisponiveis() > 0) {
            conta.setQuantidadeSaquesDisponiveis(conta.getQuantidadeSaquesDisponiveis() - 1);
        } else {
            return new ResponseEntity<>("Quantidade de saque zerada", HttpStatus.PRECONDITION_FAILED);
        }

        // Saldo em conta zerado:
        if (conta.getSaldo() <= 0) {
            return new ResponseEntity<>("Saldo insuficiente para o saque", HttpStatus.PRECONDITION_FAILED);
        }

        conta.setSaldo(conta.getSaldo() - saqueRequestDto.getValorSaque());

        Transacao transacao = GeradorTransacao.saque(conta.getIdConta(), TipoTransacao.SAQUE, saqueRequestDto.getValorSaque(), conta.getSaldo());
        transacao.setContaDestino(conta.getIdConta());
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
    public ResponseEntity<?> pix(TransferenciaRequestDTO transferenciaRequestDTO) {

        var responseDto = new TransferenciaResponseDTO();
        Conta contaOringem = findByNumeroConta(transferenciaRequestDTO.getContaOrigem());
        Conta contaDestino = findByNumeroConta(transferenciaRequestDTO.getContaDestino());
        // Contas não ATIVAS.
        if (!contaOringem.getContaStatus().equals(ContaStatus.ATIVO) || !contaDestino.getContaStatus().equals(ContaStatus.ATIVO)) {
            return new ResponseEntity<>("Conta não Ativa", HttpStatus.PRECONDITION_FAILED);
        }
        // Saldo menor que o valor:
        if (contaOringem.getSaldo() < transferenciaRequestDTO.getValorTransacao()) {
            return new ResponseEntity<>("Saldo insuficiente para a tranferencia, PIX", HttpStatus.PRECONDITION_FAILED);
        }
        Transacao transacao = GeradorTransacao.gerarPixDocTed(contaDestino.getIdConta(), TipoTransacao.PIX, transferenciaRequestDTO.getValorTransacao(), contaOringem.getSaldo());
        transacao.setContaDestino(contaDestino.getIdConta());
        transacao.setContaOrigem(contaOringem.getIdConta());
        responseDto.setSaldoAntigo(contaOringem.getSaldo());

        contaOringem.setSaldo(contaOringem.getSaldo() - transferenciaRequestDTO.getValorTransacao());
        contaDestino.setSaldo(contaDestino.getSaldo() + transferenciaRequestDTO.getValorTransacao());
        responseDto.setSaldoAtual(contaOringem.getSaldo());
        transacao.setSaldoAtual(contaOringem.getSaldo());

        contaRepository.save(contaDestino);
        contaRepository.save(contaOringem);
        transacaoService.save(transacao);

        responseDto.setDataTransacao(LocalDateTime.now());
        responseDto.setContaOrigem(transferenciaRequestDTO.getContaOrigem());
        responseDto.setContaDestino(transferenciaRequestDTO.getContaDestino());
        responseDto.setValorTransacao(transferenciaRequestDTO.getValorTransacao());
        responseDto.setTipoTransacao(TipoTransacao.PIX);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @Override
    public TransferenciaResponseDTO doc(TransferenciaRequestDTO transferenciaRequestDTO) {
        var responseDto = new TransferenciaResponseDTO();
        Conta contaOringem = findByNumeroConta(transferenciaRequestDTO.getContaOrigem());
        Conta contaDestino = findByNumeroConta(transferenciaRequestDTO.getContaDestino());

        Transacao transacao = GeradorTransacao.gerarPixDocTed(contaDestino.getIdConta(), TipoTransacao.DOC, transferenciaRequestDTO.getValorTransacao(), contaOringem.getSaldo());
        transacao.setContaDestino(contaDestino.getIdConta());
        transacao.setContaOrigem(contaOringem.getIdConta());
        responseDto.setSaldoAntigo(contaOringem.getSaldo());

        contaOringem.setSaldo(contaOringem.getSaldo() - transferenciaRequestDTO.getValorTransacao());
        contaDestino.setSaldo(contaDestino.getSaldo() + transferenciaRequestDTO.getValorTransacao());
        responseDto.setSaldoAtual(contaOringem.getSaldo());
        transacao.setSaldoAtual(contaOringem.getSaldo());

        contaRepository.save(contaDestino);
        contaRepository.save(contaOringem);
        transacaoService.save(transacao);

        responseDto.setDataTransacao(LocalDateTime.now());
        responseDto.setContaOrigem(transferenciaRequestDTO.getContaOrigem());
        responseDto.setContaDestino(transferenciaRequestDTO.getContaDestino());
        responseDto.setValorTransacao(transferenciaRequestDTO.getValorTransacao());
        responseDto.setTipoTransacao(TipoTransacao.DOC);

        return responseDto;
    }

    @Override
    public TransferenciaResponseDTO ted(TransferenciaRequestDTO transferenciaRequestDTO) {
        var responseDto = new TransferenciaResponseDTO();
        Conta contaOringem = findByNumeroConta(transferenciaRequestDTO.getContaOrigem());
        Conta contaDestino = findByNumeroConta(transferenciaRequestDTO.getContaDestino());

        Transacao transacao = GeradorTransacao.gerarPixDocTed(contaDestino.getIdConta(), TipoTransacao.TED, transferenciaRequestDTO.getValorTransacao(), contaOringem.getSaldo());
        transacao.setContaDestino(contaDestino.getIdConta());
        transacao.setContaOrigem(contaOringem.getIdConta());
        responseDto.setSaldoAntigo(contaOringem.getSaldo());

        contaOringem.setSaldo(contaOringem.getSaldo() - transferenciaRequestDTO.getValorTransacao());
        contaDestino.setSaldo(contaDestino.getSaldo() + transferenciaRequestDTO.getValorTransacao());
        responseDto.setSaldoAtual(contaOringem.getSaldo());
        transacao.setSaldoAtual(contaOringem.getSaldo());

        contaRepository.save(contaDestino);
        contaRepository.save(contaOringem);
        transacaoService.save(transacao);

        responseDto.setDataTransacao(LocalDateTime.now());
        responseDto.setContaOrigem(transferenciaRequestDTO.getContaOrigem());
        responseDto.setContaDestino(transferenciaRequestDTO.getContaDestino());
        responseDto.setValorTransacao(transferenciaRequestDTO.getValorTransacao());
        responseDto.setTipoTransacao(TipoTransacao.TED);

        return responseDto;
    }


    @Override
    public Optional<Conta> findById(String id) {
        var res = contaRepository.findById(id);
        return contaRepository.findById(id);
    }




}
