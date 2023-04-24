package com.banco.main.domain;

import com.banco.main.domain.infoTransacao.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TRANSACAO")
@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Transacao {

    @Id
    @GenericGenerator(name="UUIDGenerator",strategy = "uuid")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;
//    @Min(value = 0L, message = "Insira um valor positivo")
    @PositiveOrZero
    private Double valorTransacao;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataTransacao;
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao; /// PIX, TED, DOC, DEPOSITO;
    private String contaOrigem;
    private String contaDestino;
    private Double saldoAtual;
    private Double saldoAntigo;


}
