package com.banco.main.service;

import com.banco.main.domain.Cliente;
import com.banco.main.useCases.dtos.ClienteDto;
import com.banco.main.useCases.dtos.RetornaClienteContaDto;

public interface ClienteService {

    RetornaClienteContaDto save(ClienteDto clienteDto);

    Cliente findById(String id);


}
