package com.indracompany.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indracompany.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public Cliente findByEmail(String email);
	
	public Optional<Cliente> findByCpf(String cpf);
	
	// esse
	public Page<Cliente> findByNomeContaining(String nome, Pageable pageable);
	
	// ou esse
	@Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:nome%")
	public Page<Cliente> buscarPorNome(@Param("nome") String nome, Pageable pageRequest);
}
