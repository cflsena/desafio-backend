package br.com.desafio.backend.api.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.backend.api.controller.dto.JobRequest;
import br.com.desafio.backend.api.controller.dto.JobResponse;
import br.com.desafio.backend.api.controller.dto.JobStatusRequest;
import br.com.desafio.backend.api.entity.JobEntity;
import br.com.desafio.backend.api.filter.JobFilter;
import br.com.desafio.backend.api.repository.custom.paginator.PageCustom;
import br.com.desafio.backend.api.service.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/servicos")
@Tag(name = "Serviços", description = "API de Serviços")
public class JobController {

	@Autowired
	private JobService jobService;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Retornar um serviço cadastrado pelo id", description = "", tags = { "job" })
	public ResponseEntity<JobResponse> getJobById(@PathVariable("id") Long id) {
		Optional<JobEntity> op = getService().findById(id);
		if (op.isPresent()) {
			JobEntity foundJob = op.get();
			JobResponse jobResponse = JobResponse.create();
			jobResponse = JobResponse.from(foundJob);
			return ResponseEntity.ok(jobResponse);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/filtro")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Retorna todos os serviços cadastrados, utilizando os atributos do DTO JobFilter como filtro", description = "Lista de serviços paginadas", tags = {
			"job" })
	public ResponseEntity<PageCustom> getJobByFilter(JobFilter filter) {
		PageCustom jobPageCustom = getService().findJobByFilter(filter);
		if (jobPageCustom != null && jobPageCustom.getListObject().size() > 0) {
			return ResponseEntity.ok(jobPageCustom);
		}
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Criar um novo serviço", description = "", tags = { "job" })
	public ResponseEntity<JobResponse> createJob(@Valid @RequestBody JobRequest job) {

		JobEntity jobToSave = JobEntity.create();
		JobResponse jobResponse = JobResponse.create();

		jobToSave = JobEntity.from(job);
		JobEntity jobCreated = getService().createJob(jobToSave);
		jobResponse = JobResponse.from(jobCreated);

		return ResponseEntity.status(HttpStatus.CREATED).body(jobResponse);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Atualizar as propriedades de um serviço pelo id", description = "", tags = { "job" })
	public ResponseEntity<JobResponse> updateJob(@PathVariable("id") Long id, @Valid @RequestBody JobRequest job) {
		JobEntity jobToUpdate = JobEntity.create();
		JobResponse jobResponse = JobResponse.create();
		jobToUpdate = JobEntity.from(job);
		Object obj = getService().update(jobToUpdate, id);
		JobEntity jobUpdated = (JobEntity) obj;
		jobResponse = JobResponse.from(jobUpdated);
		return ResponseEntity.ok(jobResponse);
	}

	@PatchMapping("/{id}/status")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Atualizar o status de um serviço pelo id", description = "", tags = { "job" })
	public void updateActiveProperty(@PathVariable Long id, @Valid @RequestBody JobStatusRequest jobStatus,
			HttpServletResponse response) {
		getService().updateJobStatus(jobStatus.getActive(), id);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Excluir um serviço pelo id", description = "", tags = { "job" })
	protected void delete(@PathVariable("id") Long id) {
		getService().deleteById(id);
	}

	private JobService getService() {
		return this.jobService;
	}

}
