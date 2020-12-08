package br.com.desafio.backend.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.desafio.backend.api.entity.JobEntity;
import br.com.desafio.backend.api.repository.JobRepository;
import br.com.desafio.backend.api.service.JobService;
import br.com.desafio.backend.api.service.common.GenericServiceAbstract;

@Service
public class JobServiceImpl extends GenericServiceAbstract<JobEntity, Long> implements JobService {

	@Autowired
	private JobRepository jobRepository;

	@Override
	public JpaRepository<JobEntity, Long> getRepository() {
		return jobRepository;
	}

	@Override
	public void updateJobStatus(Boolean status, Long id) {

	}
}
