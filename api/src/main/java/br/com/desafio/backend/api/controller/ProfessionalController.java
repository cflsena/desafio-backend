	package br.com.desafio.backend.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.backend.api.controller.dto.ProfessionalRequest;
import br.com.desafio.backend.api.controller.dto.ProfessionalResponse;
import br.com.desafio.backend.api.entity.ProfessionalEntity;
import br.com.desafio.backend.api.service.ProfessionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/profissionais")
@Tag(name = "Profissionais", description = "API de Profissionais")
public class ProfessionalController {

	@Autowired
	private ProfessionalService professionalService;

	@Operation(summary = "Criar um novo profissional", description = "", tags = { "professional" })
	@PostMapping
	public ResponseEntity<ProfessionalResponse> createProfessional(
			@Valid @RequestBody ProfessionalRequest professional) {

		ProfessionalEntity professionalToSave = ProfessionalEntity.create();
		ProfessionalResponse professionalResponse = ProfessionalResponse.create();
		professionalToSave = ProfessionalEntity.from(professional);
		ProfessionalEntity professionalCreated = getService().createProfessional(professionalToSave);
		professionalResponse = ProfessionalResponse.from(professionalCreated);

		return ResponseEntity.status(HttpStatus.CREATED).body(professionalResponse);
	}

	private ProfessionalService getService() {
		return this.professionalService;
	}

}
