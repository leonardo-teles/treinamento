package com.indracompany.enums;

public enum TipoTransacao {

	DEPOSITO("Depósito"), SAQUE("Saque"), TRANSFERENCIA("Transferência");
	
	private String descricao;
	
	TipoTransacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
