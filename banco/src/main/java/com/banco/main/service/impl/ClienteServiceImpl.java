package com.banco.main.service.impl;

import com.banco.main.domain.Cliente;
import com.banco.main.domain.infoCliente.TipoDocumento;
import com.banco.main.domain.infoConta.TipoConta;
import com.banco.main.useCases.adapters.ClienteAdapter;
import com.banco.main.useCases.adapters.ContaAdapter;
import com.banco.main.useCases.adapters.EnderecoAdapter;
import com.banco.main.useCases.dtos.ClienteDto;
import com.banco.main.useCases.dtos.RetornaClienteContaDto;
import com.banco.main.service.ClienteService;
import com.banco.main.useCases.exceptionHandler.DocumentoInvalidoError;
import com.banco.main.useCases.util.EnderecoUtil;
import com.banco.main.useCases.util.GeradorContaUtil;
import com.banco.main.useCases.util.ValidarDocumentoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    GeradorContaUtil geradorContaUtil;
    @Autowired
    ClienteAdapter clienteAdapter;
    @Autowired
    ContaAdapter contaAdapter;
    @Autowired
    EnderecoUtil enderecoUtil;
    @Autowired
    EnderecoAdapter enderecoAdapter;
    @Autowired
    ValidarDocumentoUtil validarDocumentoUtil;

    @Override
    public RetornaClienteContaDto save(ClienteDto clienteDto) {

        var cpfValido = validarDocumentoUtil.validarCPF(clienteDto.getDocumento());
        var cnpjVal = validarDocumentoUtil.validarCNPJ(clienteDto.getDocumento());

        if (cpfValido) {


            Cliente cliente = Cliente.builder()
                    .nome(clienteDto.getNome())
                    .documento(clienteDto.getDocumento())
                    .tipoDocumento(clienteDto.getTipoDocumento())
                    .telefone(clienteDto.getTelefone())
                    .email(clienteDto.getEmail())
                    .senha(clienteDto.getSenha())
                    .tipoConta(clienteDto.getTipoConta())
                    .nomeBanco(clienteDto.getNomeBanco())
                    .build();

//            if (clienteDto.getTipoDocumento() == TipoDocumento.CPF) {
//                clienteDto.setTipoConta(TipoConta.PF);
//            }
            if (clienteDto.getTipoConta() == TipoConta.PF) {
                clienteDto.setTipoDocumento(TipoDocumento.CPF);
            }

            Cliente cliente1 = clienteAdapter.saveCliente(cliente);
            var conta = geradorContaUtil.gerarContaInit(cliente1);
            var contaCriada = contaAdapter.saveConta(conta);
            var endereco = enderecoUtil.saveEndereco(cliente1,clienteDto);
            var enderecoCriado = enderecoAdapter.save(endereco);

            return RetornaClienteContaDto.builder()
                    .idCliente(cliente.getId())
                    .nome(clienteDto.getNome())
                    .telefone(clienteDto.getTelefone())
                    .email(clienteDto.getEmail())
                    .tipoConta(clienteDto.getTipoConta())
                    .numeroConta(contaCriada.getNumeroConta())
                    .digito(contaCriada.getDigito())
                    .agencia(contaCriada.getAgencia())
                    .nomeBanco(clienteDto.getNomeBanco())
                    .build();

        } else if (cnpjVal) {
            Cliente cliente = Cliente.builder()
                    .nome(clienteDto.getNome())
                    .documento(clienteDto.getDocumento())
                    .tipoDocumento(clienteDto.getTipoDocumento())
                    .telefone(clienteDto.getTelefone())
                    .email(clienteDto.getEmail())
                    .senha(clienteDto.getSenha())
                    .tipoConta(clienteDto.getTipoConta())
                    .nomeBanco(clienteDto.getNomeBanco())
                    .build();

            Cliente cliente1 = clienteAdapter.saveCliente(cliente);
            var conta = geradorContaUtil.gerarContaInit(cliente1);
            var contaCriada = contaAdapter.saveConta(conta);
            var endereco = enderecoUtil.saveEndereco(cliente1,clienteDto);
            var enderecoCriado = enderecoAdapter.save(endereco);

            return RetornaClienteContaDto.builder()
                    .idCliente(cliente.getId())
                    .nome(clienteDto.getNome())
                    .telefone(clienteDto.getTelefone())
                    .email(clienteDto.getEmail())
                    .tipoConta(clienteDto.getTipoConta())
                    .numeroConta(contaCriada.getNumeroConta())
                    .digito(contaCriada.getDigito())
                    .agencia(contaCriada.getAgencia())
                    .nomeBanco(clienteDto.getNomeBanco())
                    .build();
        }
        throw new DocumentoInvalidoError();
    }


    @Override
    public Cliente findById(String id) {
        return clienteAdapter.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Id do cliente não existe ou não encontrado"));
    }



}
