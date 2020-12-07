package br.com.desafio.backend.api.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

@RestController
@RequestMapping("/profissionais")
public class ProfessionalController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProfessionalService professionalService;

    @PostMapping
    public ResponseEntity<ProfessionalResponse> createProfessional(
            @Valid @RequestBody ProfessionalRequest professional) {

        ProfessionalEntity professionalCreated;
        ProfessionalEntity professionalToSave = ProfessionalEntity.getInstance();
        ProfessionalResponse professionalResponse = ProfessionalResponse.getInstance();

        getModelMapper().map(professional, professionalToSave);
        Object obj = getService().save(professionalToSave);
        professionalCreated = (ProfessionalEntity) obj;
        getModelMapper().map(professionalCreated, professionalResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(professionalResponse);
    }

    private ModelMapper getModelMapper() {
        return modelMapper;
    }

    private ProfessionalService getService() {
        return this.professionalService;
    }

}
