package com.banco.Main.service;

import com.banco.Main.useCases.dtos.DepositoRequestDto;

public interface DepositoService {

    DepositoRequestDto save(DepositoRequestDto depositoRequestDto);
}
