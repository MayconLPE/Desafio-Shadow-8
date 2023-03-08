package com.banco.Main.repository;

import com.banco.Main.domain.Cliente;
import com.banco.Main.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, String> {

    Optional<Cliente> findByDocumento(String documento);

    Optional<Conta> findByNumeroConta(Integer numeroConta);


}
