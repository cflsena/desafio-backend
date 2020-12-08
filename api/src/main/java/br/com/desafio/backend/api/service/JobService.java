package br.com.desafio.backend.api.service;

import br.com.desafio.backend.api.entity.JobEntity;
import br.com.desafio.backend.api.filter.JobFilter;
import br.com.desafio.backend.api.repository.custom.paginator.PageCustom;
import br.com.desafio.backend.api.service.common.interfaces.GenericService;

public interface JobService extends GenericService<JobEntity, Long>{
    void updateJobStatus(Boolean status, Long id);
    PageCustom findJobByFilter(JobFilter job);
}
