package com.banco.Main.repository;

import com.banco.Main.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByDocumento(String id);
}
