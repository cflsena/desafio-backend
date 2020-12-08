package br.com.desafio.backend.api.controller;

import br.com.desafio.backend.api.controller.dto.JobRequest;
import br.com.desafio.backend.api.controller.dto.JobResponse;
import br.com.desafio.backend.api.controller.dto.JobStatusRequest;
import br.com.desafio.backend.api.entity.JobEntity;
import br.com.desafio.backend.api.service.JobService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class JobController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JobService jobService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<JobResponse> createJob(
            @Valid @RequestBody JobRequest job) {

        JobEntity jobCreated;
        JobEntity jobToSave = JobEntity.getInstance();
        JobResponse jobResponse = JobResponse.getInstance();

        getModelMapper().map(job, jobToSave);
        Object obj = getService().save(jobToSave);
        jobCreated = (JobEntity) obj;
        getModelMapper().map(jobCreated, jobResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(jobResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JobResponse> getJobById(@PathVariable("id") Long id) {
        Optional<JobEntity> op = getService().findById(id);
        if (op.isPresent()) {
            JobEntity foundJob = op.get();
            JobResponse jobResponse = JobResponse.getInstance();
            getModelMapper().map(foundJob, jobResponse);
            return ResponseEntity.ok(jobResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JobResponse> updateJob(@PathVariable("id") Long id, @Valid @RequestBody JobRequest job) {
        JobEntity jobUpdated;
        JobEntity jobToUpdate = JobEntity.getInstance();
        JobResponse jobResponse = JobResponse.getInstance();
        getModelMapper().map(job, jobToUpdate);
        Object obj = getService().save(jobToUpdate);
        jobUpdated = (JobEntity) obj;
        getModelMapper().map(jobUpdated, jobResponse);
        return ResponseEntity.ok(jobResponse);
    }

    @PatchMapping("/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateActiveProperty(@PathVariable Long id, @RequestBody JobStatusRequest jobStatus,
                                     HttpServletResponse response) {
        getService().updateJobStatus(jobStatus.getActive(), id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    protected void delete(@PathVariable("id") Long id) {
        getService().deleteById(id);
    }

    private ModelMapper getModelMapper() {
        return modelMapper;
    }

    private JobService getService() {
        return this.jobService;
    }

}
