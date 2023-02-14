package com.banco.Main.domain;

import com.banco.Main.domain.infoCliente.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "CLIENTE")
@Entity
public class Cliente {
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

    @OneToMany // Um cliente para muitas Contas
    @JoinColumn(name = "idConta")
    private List<Conta> contas;
    @OneToMany
    @JoinColumn(name = "idEndereco")
    private List<Endereco> enderecos;
    @OneToMany
    @JoinColumn(name = "idTransacao")
    private List<Transacao> transacoes;


}
