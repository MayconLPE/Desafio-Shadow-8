package com.banco.Main.useCases.util;

import com.banco.Main.domain.Cliente;
import com.banco.Main.useCases.adapters.ClienteAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PegarIdClienteUtil {
    @Autowired
    ClienteAdapter clienteAdapter;

    public Optional<Cliente> buscarId (String id) {
        var cliente = clienteAdapter.findById(id);
        return cliente;
    }
}
