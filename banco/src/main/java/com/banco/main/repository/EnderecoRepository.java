package com.banco.main.repository;

import com.banco.main.domain.infoCliente.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,String> {

}
