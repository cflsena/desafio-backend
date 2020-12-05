package br.com.desafio.backend.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.desafio.backend.api.repository.ProfessionalRepository;
import br.com.desafio.backend.api.service.ProfessionalService;

public class ProfessionalServiceImpl implements ProfessionalService {

	@Autowired
	private ProfessionalRepository professionalRepository;

	public ProfessionalRepository getProfessionalRepository() {
		return professionalRepository;
	}

}
