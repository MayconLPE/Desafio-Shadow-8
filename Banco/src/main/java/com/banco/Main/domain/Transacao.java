package com.banco.Main.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    private LocalDateTime dataTransacao;


    @ManyToOne
    @JoinColumn(name = "transacoesId")
    private Cliente cliente;
}
