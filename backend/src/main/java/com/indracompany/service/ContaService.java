package com.indracompany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indracompany.dto.ContaDTO;
import com.indracompany.model.Conta;
import com.indracompany.repository.ContaRepository;
import com.indracompany.service.exception.ObjectNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	@Transactional(readOnly = true)
	public Page<ContaDTO> listarTodasPaginado(PageRequest pageRequest) {
		Page<Conta> lista = contaRepository.findAll(pageRequest);
		
		return lista.map(conta -> new ContaDTO(conta));
	}
	
	@Transactional(readOnly = true)
	public ContaDTO buscarPorAgencia(String agencia) {
		Optional<Conta> opt = contaRepository.findByAgencia(agencia);
		
		Conta conta = opt.orElseThrow(() -> new ObjectNotFoundException("Conta de nº " + agencia + " não encontrada."));
		
		return new ContaDTO(conta);
	}

	@Transactional(readOnly = true)
	public List<Conta> buscarPorCliente(Long clienteId) {
		return contaRepository.findByCliente(clienteId);
	}

	public Conta inserir(Conta conta) {
		
		
		
		
		
		
		return null;
	}
}