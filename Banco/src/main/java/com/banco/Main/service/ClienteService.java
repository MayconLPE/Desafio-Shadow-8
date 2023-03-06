package com.banco.Main.service;

import com.banco.Main.domain.Cliente;
import com.banco.Main.useCases.dtos.ClienteDto;
import com.banco.Main.useCases.dtos.RetornaClienteContaDto;

public interface ClienteService {

    RetornaClienteContaDto save(ClienteDto clienteDto);

    Cliente findById(String id);


}
