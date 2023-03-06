package com.banco.Main.useCases.adapters;

import com.banco.Main.domain.infoCliente.Endereco;
import com.banco.Main.repository.EnderecoRepository;
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
