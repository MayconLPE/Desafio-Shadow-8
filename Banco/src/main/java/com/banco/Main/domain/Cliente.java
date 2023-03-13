package com.banco.Main.domain;

import com.banco.Main.domain.infoCliente.TipoDocumento;
import com.banco.Main.domain.infoConta.NomeBanco;
import com.banco.Main.domain.infoConta.TipoConta;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "CLIENTE")
@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Cliente  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name="UUIDGenerator",strategy = "uuid")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;
    @Column(nullable = false)
    @NotBlank
    private String nome;
    @Column(nullable = false, unique = true)
    @NotBlank
    private String documento; // cpf, cnpj...
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento; // CPF, CNPJ;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoConta tipoConta; // PJ, PF, CNPJ;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NomeBanco nomeBanco; // BANCOPE, BANCOSP;

}
