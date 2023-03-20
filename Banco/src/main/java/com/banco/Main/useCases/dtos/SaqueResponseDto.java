package com.banco.Main.useCases.dtos;

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
public class SaqueResponseDto {

    private Integer numeroConta;
    private Integer digito;
    private Integer agencia;
    private Double valorSaque;
    private LocalDateTime data = LocalDateTime.now();
    private Double saldoAntigo;
    private Double saldoAtual;

}
