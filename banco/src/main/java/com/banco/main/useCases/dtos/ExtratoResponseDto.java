package com.banco.main.useCases.dtos;

import com.banco.main.domain.infoTransacao.TipoTransacao;
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
public class ExtratoResponseDto {
    private String id;
    private TipoTransacao tipoTransacao;
    private Double valor;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataTransacao;
    private Integer contaOrigem;
    private Integer contaDestino;
    private Double saldoAntigo;
    private Double saldoAtual;

}
