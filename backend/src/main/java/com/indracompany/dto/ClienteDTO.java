package com.indracompany.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.indracompany.model.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Campo obrigatório.")
	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	private String nome;
	
	@CPF(message = "CPF inválido.")
	private String cpf;
	
	@Email(message = "e-Mail inválido.")
	private String email;
	
	private Boolean ativo;
	
	private String observacoes;

	public ClienteDTO() {}

	public ClienteDTO(Long id, String nome, String cpf, String email, Boolean ativo, String observacoes) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.ativo = ativo;
		this.observacoes = observacoes;
	}
	
	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		cpf = cliente.getCpf();
		email = cliente.getEmail();
		ativo = cliente.getAtivo();
		observacoes = cliente.getObservacoes();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}
