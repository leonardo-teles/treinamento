package com.indracompany.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.indracompany.dto.ClienteNovoDTO;
import com.indracompany.model.Cliente;
import com.indracompany.repository.ClienteRepository;
import com.indracompany.resource.exception.FieldMessage;

public class ClienteNovoValidator implements ConstraintValidator<ClienteNovo, ClienteNovoDTO> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void initialize(ClienteNovo ann) {}

	@Override
	public boolean isValid(ClienteNovoDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> lista = new ArrayList<>();
		
		Cliente emailCli = clienteRepository.findByEmail(dto.getEmail());
		Cliente cpfCli = clienteRepository.findByCpf(dto.getCpf());
		
		if(emailCli != null) {
			lista.add(new FieldMessage("email", "e-Mail já existe."));
		}
		
		if(cpfCli != null) {
			lista.add(new FieldMessage("cpf", "CPF já existe."));
		}
		
		for (FieldMessage e : lista) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		
		return lista.isEmpty();
	}
}
