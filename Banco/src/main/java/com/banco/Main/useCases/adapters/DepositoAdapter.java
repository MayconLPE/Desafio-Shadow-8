package com.banco.Main.useCases.adapters;

import com.banco.Main.domain.infoTransacao.Deposito;
import com.banco.Main.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepositoAdapter {
    @Autowired
    DepositoRepository depositoRepository;

    public Deposito save( Deposito deposito) {
        return depositoRepository.save(deposito);
    }


}
