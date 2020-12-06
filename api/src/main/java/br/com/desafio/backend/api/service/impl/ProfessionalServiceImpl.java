package br.com.desafio.backend.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.desafio.backend.api.entity.ProfessionalEntity;
import br.com.desafio.backend.api.repository.ProfessionalRepository;
import br.com.desafio.backend.api.service.ProfessionalService;
import br.com.desafio.backend.api.service.common.GenericServiceAbstract;

@Service
public class ProfessionalServiceImpl extends GenericServiceAbstract<ProfessionalEntity, Long>
		implements ProfessionalService {

	@Autowired
	private ProfessionalRepository professionalRepository;

	@Override
	public JpaRepository<ProfessionalEntity, Long> getRepository() {
		return professionalRepository;
	}

}
