package com.banco.Main.repository;

import com.banco.Main.domain.infoCliente.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,String> {

}
