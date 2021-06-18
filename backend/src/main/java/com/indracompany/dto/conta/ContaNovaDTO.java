package com.indracompany.dto.conta;

import com.indracompany.dto.ContaDTO;

public class ContaNovaDTO extends ContaDTO {
	private static final long serialVersionUID = 1L;

	private Long clienteId;

	public ContaNovaDTO() {}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
}
