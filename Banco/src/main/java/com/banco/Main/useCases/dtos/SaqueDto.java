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
public class SaqueDto {

    private Integer numeroConta;
    private Integer digito;
    private Integer agencia;
    private Double valor;
    private LocalDateTime data = LocalDateTime.now();

}
