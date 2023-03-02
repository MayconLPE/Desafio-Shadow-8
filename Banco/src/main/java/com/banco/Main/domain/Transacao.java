package com.banco.Main.domain;

import com.banco.Main.domain.infoTransacao.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Table(name = "TRANSACAO")
@Entity
public class Transacao {

    @Id
    @GenericGenerator(name="UUIDGenerator",strategy = "uuid")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;
    private Double valor;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataTransacao;
    private TipoTransacao tipoTransacao; /// PIX, TED, DOC;
    private String contaOrigim;
    private String contaDestino;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private Cliente cliente;
}
