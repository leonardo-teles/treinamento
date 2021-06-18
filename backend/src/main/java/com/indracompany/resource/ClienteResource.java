package com.indracompany.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.indracompany.dto.ClienteDTO;
import com.indracompany.dto.ContaDTO;
import com.indracompany.dto.cliente.ClienteAtualizadoDTO;
import com.indracompany.dto.cliente.ClienteNovoDTO;
import com.indracompany.model.Conta;
import com.indracompany.service.ClienteService;
import com.indracompany.service.ContaService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> listarTodos(
			@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "linhasPorPagina", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direcao", defaultValue = "ASC") String direction,
			@RequestParam(value = "ordenarPor", defaultValue = "nome") String orderBy
			) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<ClienteDTO> list = clienteService.listarTodosPaginado(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) {
		ClienteDTO dto = clienteService.buscarPorId(id);
		
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(value = "/buscar-por-cpf/{cpf}")
	public ResponseEntity<ClienteDTO> buscarPorCpf(@PathVariable String cpf) {
		ClienteDTO dto = clienteService.buscarPorCpf(cpf);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value="/{clienteId}/contas")
	public ResponseEntity<List<ContaDTO>> listarContas(@PathVariable Long clienteId) {
		List<Conta> lista = contaService.buscarPorCliente(clienteId);
		List<ContaDTO> listaDto = lista.stream().map(conta -> new ContaDTO(conta)).collect(Collectors.toList());  
		
		return ResponseEntity.ok().body(listaDto);
	}	
	
	@PostMapping
	public ResponseEntity<ClienteDTO> inserir(@Valid @RequestBody ClienteNovoDTO dto) {
		ClienteDTO cliDto = clienteService.inserir(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliDto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(cliDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteAtualizadoDTO dto) {
		ClienteDTO cliDto = clienteService.atualizar(id, dto);
		
		return ResponseEntity.ok().body(cliDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		clienteService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
}
