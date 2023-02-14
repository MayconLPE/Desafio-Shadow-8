package com.banco.Main.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
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
    private LocalDateTime dataTransacao;

    @ManyToOne
    @JoinColumn(name = "origem")
    private Cliente origem;
    @ManyToOne
    @JoinColumn(name = "destino")
    private Cliente destino;

}
