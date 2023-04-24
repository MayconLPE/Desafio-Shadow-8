package com.banco.main.useCases.adapters;

import com.banco.main.domain.infoCliente.Endereco;
import com.banco.main.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoAdapter {

    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
