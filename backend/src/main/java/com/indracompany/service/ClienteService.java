package com.indracompany.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indracompany.dto.ClienteAtualizadoDTO;
import com.indracompany.dto.ClienteDTO;
import com.indracompany.dto.ClienteNovoDTO;
import com.indracompany.model.Cliente;
import com.indracompany.repository.ClienteRepository;
import com.indracompany.service.exception.DatabaseException;
import com.indracompany.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(readOnly = true)
	public Page<ClienteDTO> listarTodosPaginado(PageRequest pageRequest) {
		Page<Cliente> lista = clienteRepository.findAll(pageRequest);
		
		return lista.map(cliente -> new ClienteDTO(cliente));
	}
	
	@Transactional(readOnly = true)
	public ClienteDTO buscarPorId(Long id) {
		Optional<Cliente> opt = clienteRepository.findById(id);
		
		Cliente cliente = opt.orElseThrow(() -> new ObjectNotFoundException("Cliente de id nº " + id + " não encontrado."));
		
		return new ClienteDTO(cliente);
	}
	
	@Transactional
	public ClienteDTO inserir(ClienteNovoDTO dto) {
		Cliente cliente = new Cliente();
		
		BeanUtils.copyProperties(dto, cliente);
		//converterDto(dto, cliente);
		
		cliente = clienteRepository.save(cliente);
		
		return new ClienteDTO(cliente);
	}
	
	@Transactional
	public ClienteDTO atualizar(Long id, ClienteAtualizadoDTO dto) {
		try {
			Cliente cliente = clienteRepository.getOne(id);	
			
			BeanUtils.copyProperties(dto, cliente, "id");
			//converterDto(dto, cliente);
			
			cliente = clienteRepository.save(cliente);
			
			return new ClienteDTO(cliente);
			
		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Id nº " + id + " não encontrado.");
		}
	}
	
	@Transactional
	public void excluir(Long id) {
		try {
			clienteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Id nº " + id + " não encontrado.");
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade de dados");
		}
	}

	@SuppressWarnings("unused")
	private void converterDto(ClienteDTO dto, Cliente cliente) {
		cliente.setNome(dto.getNome());
		cliente.setCpf(dto.getCpf());
		cliente.setEmail(dto.getEmail());
		cliente.setAtivo(dto.getAtivo());
		cliente.setObservacoes(dto.getObservacoes());
	}
}