package com.banco.Main.useCases.dtos;

import com.banco.Main.domain.infoTransacao.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TransferenciaRequestDTO {

    @PositiveOrZero
    private Double valorTransacao;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataTransacao;
    private TipoTransacao tipoTransacao; /// PIX, TED, DOC, DEPOSITO;
    private Integer contaOrigem;
    private Integer contaDestino;
    private Double saldoAntigo;
    private Double saldoAtual;

}
