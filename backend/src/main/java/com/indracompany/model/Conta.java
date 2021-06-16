package com.indracompany.model;

import java.math.BigDecimal;

import com.indracompany.enums.TipoConta;

public class Conta {

	private Long id;

	private String agencia;
	
	private String numero;
	
	private BigDecimal saldo;
	
	private TipoConta tipo;	

	private Cliente cliente;
}
