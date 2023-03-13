package com.banco.Main.domain.infoCliente;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ENDERECO")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name="UUIDGenerator",strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;
    @Column(nullable = false)
    @NotBlank
    private String idCliente;
    @Column(nullable = false)
    @NotBlank
    private String cep;
    @Column(nullable = false)
    @NotBlank
    private String bairro;
    @Column(nullable = false)
    @NotBlank
    private String numeroEndereco;
    @Column(nullable = false)
    @NotBlank
    private String rua;
    @Column(nullable = false)
    @NotBlank
    private String cidade;
    @Column(nullable = false)
    @NotBlank
    private String uf;
    private String complemento; // Trabalho ou casa

//    @ManyToOne(cascade = CascadeType.ALL)
//    private Cliente cliente;

}
