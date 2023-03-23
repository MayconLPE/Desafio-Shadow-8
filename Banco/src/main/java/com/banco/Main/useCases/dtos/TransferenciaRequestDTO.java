package com.banco.Main.useCases.dtos;

import com.banco.Main.domain.infoTransacao.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TransferenciaRequestDTO {

//    @Id
//    @GenericGenerator(name="UUIDGenerator",strategy = "uuid")
//    @GeneratedValue(generator = "UUIDGenerator")
//    private String id;
    @PositiveOrZero
    private Double valor;
    private LocalDateTime dataTransacao;
    private TipoTransacao tipoTransacao; /// PIX, TED, DOC, DEPOSITO;
    private Integer contaOrigem;
    private Integer contaDestino;
    private Double saldoAntigo;
    private Double saldoAtual;





}
