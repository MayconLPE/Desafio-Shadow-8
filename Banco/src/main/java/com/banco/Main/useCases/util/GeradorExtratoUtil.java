package com.banco.Main.useCases.util;

import com.banco.Main.useCases.adapters.ClienteAdapter;
import com.banco.Main.useCases.adapters.ContaAdapter;
import com.banco.Main.useCases.dtos.ClienteDto;
import com.banco.Main.useCases.dtos.ContaDto;
import com.banco.Main.useCases.dtos.ExtratoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
//public class GeradorExtratoUtil {
//
//    @Autowired
//    ClienteAdapter clienteAdapter;
//    @Autowired
//    ContaAdapter contaAdapter;
//
//    public ExtratoResponseDto extrato(ContaDto contaDto) {
//
//        var conta = contaAdapter.findByNumeroConta(contaDto.getNumeroConta());
//
//
//
//    }
//}
