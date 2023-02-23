package com.banco.Main.domain;

import com.banco.Main.domain.infoConta.ContaStatus;
import com.banco.Main.domain.infoConta.NomeBanco;
import com.banco.Main.domain.infoConta.TipoPessoa;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    private ContaStatus contaStatus; // PENDENTE, ATIVO, BLOQUEADO.
    @Column(nullable = false)
    private NomeBanco nomeBanco; // BANCOPE, BANCOSP;
    @Column(nullable = false)
    private TipoPessoa tipoPessoa; //PJ, PF, GOV;
    @Column(nullable = false)
    @Size(max = 5)
    @NotBlank
    private String agencia;
//    @Size(max = 6)
    @Column(nullable = false,length = 6)
    @NotBlank
    private String numeroConta;
    @Column(nullable = false)
    @Size(max = 1, message = "digito Maximo 1 caracter")// quantidade caracteres
    @NotBlank
    private String digito;
    private Double saldo = 0.0;

    @ManyToOne // Muitas contas para um Cliente
    @JoinColumn(name = "clienteId") // coluna que vai ser chave primaria
    private Cliente cliente;
}
