package com.indracompany.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.indracompany.dto.ContaDTO;
import com.indracompany.model.Conta;
import com.indracompany.service.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {

	@Autowired
	private ContaService contaService;
	
	@GetMapping
	public ResponseEntity<Page<ContaDTO>> listarTodas(
			@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "linhasPorPagina", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direcao", defaultValue = "ASC") String direction,
			@RequestParam(value = "ordenarPor", defaultValue = "agencia") String orderBy
			) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<ContaDTO> list = contaService.listarTodasPaginado(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{agencia}")
	public ResponseEntity<ContaDTO> buscarPorAgencia(@PathVariable String agencia) {
		ContaDTO dto = contaService.buscarPorAgencia(agencia);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<Conta> inserir(@Valid @RequestBody Conta conta) {
		conta = contaService.inserir(conta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conta.getId()).toUri();
		
		return ResponseEntity.created(uri).body(conta);
	}
}
