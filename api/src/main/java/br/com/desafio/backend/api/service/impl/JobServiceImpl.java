package br.com.desafio.backend.api.service.impl;

import br.com.desafio.backend.api.entity.JobEntity;
import br.com.desafio.backend.api.exception.custom.UniqueConstraintException;
import br.com.desafio.backend.api.filter.JobFilter;
import br.com.desafio.backend.api.repository.JobRepository;
import br.com.desafio.backend.api.repository.custom.JobRepositoryCustom;
import br.com.desafio.backend.api.repository.custom.paginator.PageCustom;
import br.com.desafio.backend.api.service.JobService;
import br.com.desafio.backend.api.service.common.GenericServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class JobServiceImpl extends GenericServiceAbstract<JobEntity, Long> implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobRepositoryCustom jobRepositoryCustom;

    @Override
    public JpaRepository<JobEntity, Long> getRepository() {
        return jobRepository;
    }

    @Transactional
    @Override
    public JobEntity createJob(JobEntity job) {
        validateJobConstraints(job);
        Object obj = getRepository().save(job);
        return (JobEntity) obj;
    }

    @Transactional
    @Override
    public void updateJobStatus(Boolean status, Long id) {
        Optional<JobEntity> optAccount = findById(id);
        validateEntity(optAccount);
        JobEntity accountToUpdate = optAccount.get();
        accountToUpdate.setActive(status);
        getRepository().save(accountToUpdate);
        getRepository().flush();
    }

    @Transactional(readOnly = true)
    @Override
    public PageCustom findJobByFilter(JobFilter filter) {
        return this.jobRepositoryCustom.findByFilter(filter);
    }

    private void validateJobConstraints(JobEntity job) {
        Optional<JobEntity> optJob = jobRepository.findByCategory(job.getCategory());
        if (optJob.isPresent()) {
            JobEntity foundJob = optJob.get();
            if (foundJob != null) {
                throw new UniqueConstraintException("Já existe um serviço cadastrado para a categoria selecionada");
            }
        }
    }
}
