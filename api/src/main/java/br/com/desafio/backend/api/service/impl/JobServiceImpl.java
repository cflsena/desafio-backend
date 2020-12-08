package br.com.desafio.backend.api.service.impl;

import br.com.desafio.backend.api.filter.JobFilter;
import br.com.desafio.backend.api.repository.custom.paginator.PageCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.desafio.backend.api.entity.JobEntity;
import br.com.desafio.backend.api.repository.JobRepository;
import br.com.desafio.backend.api.service.JobService;
import br.com.desafio.backend.api.service.common.GenericServiceAbstract;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class JobServiceImpl extends GenericServiceAbstract<JobEntity, Long> implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public JpaRepository<JobEntity, Long> getRepository() {
        return jobRepository;
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
    public PageCustom findJobByFilter(JobFilter job) {
        return null;
    }
}
