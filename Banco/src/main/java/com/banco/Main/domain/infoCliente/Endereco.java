package com.banco.Main.domain.infoCliente;

import com.banco.Main.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ENDERECO")
public class Endereco {
    @Id
    @GenericGenerator(name="UUIDGenerator",strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;

    @Column(nullable = false)
    @NotBlank
    private String cep;
    @Column(nullable = false)
    @NotBlank
    private String bairro;
    @Column(nullable = false)
    @NotBlank
    private String numero;
    @Column(nullable = false)
    @NotBlank
    private String rua;
    @Column(nullable = false)
    @NotBlank
    private String cidade;
    @Column(nullable = false)
    @NotBlank
    private String uf;
    private String infoAdcional; // Trabalho ou casa

}
