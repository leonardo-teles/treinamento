package com.indracompany.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indracompany.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	public Optional<Conta> findByAgencia(String agencia);
	
	@Query("SELECT c FROM Conta c WHERE c.cliente.id = :clienteId ORDER BY c.agencia")
	public List<Conta> findByCliente(@Param("clienteId") Long cliente_id);
}
