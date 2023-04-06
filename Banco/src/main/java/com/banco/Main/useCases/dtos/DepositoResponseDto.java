package com.banco.Main.useCases.dtos;

import com.banco.Main.domain.infoConta.ContaStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DepositoResponseDto {

    private Integer numeroConta;
    private Integer digito;
    private Integer agencia;
    private Double valorDeposito;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime data = LocalDateTime.now();
    private Double saldoAntigo;
    private Double saldoAtual;

}
