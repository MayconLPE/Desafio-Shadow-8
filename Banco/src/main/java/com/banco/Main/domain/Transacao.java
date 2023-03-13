package com.banco.Main.domain;

import com.banco.Main.domain.infoTransacao.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Double valor;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataTransacao;
    private TipoTransacao tipoTransacao; /// PIX, TED, DOC;
    private String contaOrigem;
    private String contaDestino;

}
