package br.com.desafio.backend.api.repository.custom.impl;

import br.com.desafio.backend.api.entity.JobEntity;
import br.com.desafio.backend.api.filter.JobFilter;
import br.com.desafio.backend.api.repository.custom.JobRepositoryCustom;
import br.com.desafio.backend.api.repository.custom.paginator.PageCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepositoryCustomImpl implements JobRepositoryCustom {
    @Override
    public PageCustom findByFilter(JobFilter transactionFilter) {
        return null;
    }

    private Predicate[] createRestrictions(JobFilter jobFilter, CriteriaBuilder criteriaBuilder,
                                           Root<JobEntity> root) {

        List<Predicate> predicateList = new ArrayList<>();

        if (jobFilter.getId() != null) {
            predicateList.add(criteriaBuilder.equal(root.get("job"), jobFilter.getId()));
        }

//        if (jobFilter.getInitialPeriod() != null && transactionFilter.getFinalPeriod() != null
//                && !StringUtils.isBlank(transactionFilter.getInitialPeriod().toString())
//                && !StringUtils.isBlank(transactionFilter.getFinalPeriod().toString())) {
//            predicateList.add(criteriaBuilder.between(root.get("transactionDate"), transactionFilter.getInitialPeriod(),
//                    transactionFilter.getFinalPeriod()));
//        }
//
//        if (!StringUtils.isBlank(transactionFilter.getAccountType())) {
//            predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("accountType")),
//                    "%" + transactionFilter.getAccountType().toLowerCase() + "%"));
//        }
//
//        if (!StringUtils.isBlank(transactionFilter.getTransactionType())) {
//            predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("transactionType")),
//                    "%" + transactionFilter.getTransactionType().toLowerCase() + "%"));
//        }

        return predicateList.toArray(new Predicate[predicateList.size()]);
    }

}
