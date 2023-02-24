package com.banco.Main.domain;

import com.banco.Main.domain.infoCliente.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "CLIENTE")
@Entity
public class Cliente  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name="UUIDGenerator",strategy = "uuid")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;
    @Column(nullable = false)
    @NotBlank
    private String nome;

//    @Min(value = 11, message = "Valor deve ser maior que 11") // Para cpf
//    @Max(value = 14, message = "Valor deve ser menor que 14") // Para cnpj
    @Column(nullable = false, unique = true)
    @NotBlank
    private String documento; // cpf, cnpj...
    @Column(nullable = false)
    @NotBlank
    private String telefone;
    @Column(nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;
    @Column(nullable = false)
    @NotBlank
    private String senha;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime registroCadastro;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "codigo_cliente")
    private List<Endereco> enderecos = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "codigo_cliente")
    private List<Conta> contas = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "codigo_cliente")
    private List<Transacao> transacoes = new ArrayList<>();


}
