package com.banco.Main.domain;

import com.banco.Main.domain.infoCliente.Endereco;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
@Table(name = "CLIENTES")
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
    @Column(nullable = false, unique = true, length = 11)
    @NotBlank
    @CPF
    private String cpf;
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
    @Column(nullable = false)
    private LocalDateTime registroCadastro;

    @OneToMany(mappedBy = "cliente") // Um cliente para muitas Contas
    private List<Conta> contas = new ArrayList<>();
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;
    @OneToMany(mappedBy = "cliente")
    private List<Transacao> transacoes;


}
