package com.banco.Main.domain.infoTransacao;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "DEPOSITOS")
@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Deposito {
    @Id
    @GenericGenerator(name="UUIDGenerator",strategy = "uuid")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;
    @Column(nullable = false)
    private Double valorDeposito;
    @Column(nullable = false)
    private Double saldoAnterior;
    @Column(nullable = false)
    private Double novoSaldo;


}
