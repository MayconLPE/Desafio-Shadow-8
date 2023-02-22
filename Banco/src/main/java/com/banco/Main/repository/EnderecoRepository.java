package com.banco.Main.repository;

import com.banco.Main.domain.infoCliente.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,String> {
}
