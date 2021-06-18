package com.indracompany.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.indracompany.dto.cliente.ClienteAtualizadoDTO;
import com.indracompany.model.Cliente;
import com.indracompany.repository.ClienteRepository;
import com.indracompany.resource.exception.FieldMessage;

public class ClienteAtualizadoValidator implements ConstraintValidator<ClienteAtualizado, ClienteAtualizadoDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void initialize(ClienteAtualizado ann) {}

	@Override
	public boolean isValid(ClienteAtualizadoDTO dto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long uirId = Long.parseLong(map.get("id"));
		
		List<FieldMessage> lista = new ArrayList<>();
		
		Cliente emailCli = clienteRepository.findByEmail(dto.getEmail());
		Cliente cpfCli = clienteRepository.findByCpf(dto.getCpf());
		
		if(emailCli != null && uirId != emailCli.getId()) {
			lista.add(new FieldMessage("email", "e-Mail já existe."));
		}
		
		if(cpfCli != null && uirId != cpfCli.getId()) { 
			lista.add(new FieldMessage("cpf", "CPF já existe.")); 
		}
		
		for (FieldMessage e : lista) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return lista.isEmpty();
	}

}
