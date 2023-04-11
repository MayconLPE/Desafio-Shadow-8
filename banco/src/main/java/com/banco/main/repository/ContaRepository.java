package com.banco.main.repository;

import com.banco.main.domain.Cliente;
import com.banco.main.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, String> {

    Cliente findByDocumento(String documento);

    Conta findByNumeroConta(Integer numeroConta);



}
