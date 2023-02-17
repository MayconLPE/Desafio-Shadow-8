package com.banco.Main.domain;

import com.banco.Main.domain.infoConta.ContaStatus;
import com.banco.Main.domain.infoConta.TipoConta;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "CONTAS")
@Entity
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name="UUIDGenerator",strategy = "uuid")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;
    @Column(nullable = false)
    @NotBlank
    private ContaStatus contaStatus; // PENDENTE, ATIVO, BLOQUEADO.
    @Column(nullable = false)
    @NotBlank
    private Integer agencia;
    @Column(nullable = false)
    @NotBlank
    private Integer numeroConta;
    @Column(nullable = false)
    @Min(value = 1, message = "Valor deve ser maior que 1")
    @Max(value = 9, message = "Valor deve ser menor que 9")
    @NotBlank
    private Integer digito;
    @Column(nullable = false)
    @NotBlank
    private TipoConta tipoConta; //pj, pf e gov
    private Double saldo = 0.0;


    @ManyToOne // Muitas contas para um Cliente
    @JoinColumn(name = "clienteId") // coluna que vai ser chave primaria
    private Cliente cliente;
}
