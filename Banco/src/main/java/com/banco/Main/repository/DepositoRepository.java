package com.banco.Main.repository;

import com.banco.Main.domain.infoTransacao.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositoRepository extends JpaRepository<Deposito, String> {
    List<Deposito> findByIdCliente(String id);
}
