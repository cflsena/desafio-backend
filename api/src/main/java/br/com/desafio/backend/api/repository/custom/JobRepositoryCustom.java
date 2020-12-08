package br.com.desafio.backend.api.repository.custom;

import br.com.desafio.backend.api.filter.JobFilter;
import br.com.desafio.backend.api.repository.custom.paginator.PageCustom;

public interface JobRepositoryCustom {
    PageCustom findByFilter(JobFilter transactionFilter);
}
