package com.indracompany.model;

import java.time.Instant;

import com.indracompany.enums.TipoTransacao;

public class Transacao {

	private Long id;
	
	private Instant dataTransacao;
	
	private TipoTransacao tipo;
	
	private Double valor;
	
	private String informacoes;
	
	private Conta conta;
}
