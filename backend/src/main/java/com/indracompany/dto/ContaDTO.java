package com.indracompany.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.indracompany.model.Conta;

public class ContaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String agencia;
	
	private String numero;
	
	private BigDecimal saldo;
	
	private String tipo;
	
	private Long cliente;

	public ContaDTO() {}

	public ContaDTO(Conta conta) {
		id = conta.getId();
		agencia = conta.getAgencia();
		numero = conta.getNumero();
		saldo = conta.getSaldo();
		tipo = conta.getTipo().getDescricao();
		cliente = conta.getCliente().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}	
}
