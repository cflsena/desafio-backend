package br.com.desafio.backend.api.repository.custom.impl;

import br.com.desafio.backend.api.entity.JobEntity;
import br.com.desafio.backend.api.filter.JobFilter;
import br.com.desafio.backend.api.repository.custom.JobRepositoryCustom;
import br.com.desafio.backend.api.repository.custom.common.CustomRepositoryAbstract;
import br.com.desafio.backend.api.repository.custom.paginator.PageCustom;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepositoryCustomImpl extends CustomRepositoryAbstract implements JobRepositoryCustom {
    @Override
    public PageCustom findByFilter(JobFilter jobFilter) {
        PageCustom pageCustomResult = new PageCustom();

        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<JobEntity> criteriaQuery = criteriaBuilder.createQuery(JobEntity.class);
        Root<JobEntity> root = criteriaQuery.from(JobEntity.class);
        root.alias("root_alias");

        Predicate[] predicates = createRestrictions(jobFilter, criteriaBuilder, root);

        Long count = this.count(JobEntity.class, predicates);
        this.executeCriteriaQuery(pageCustomResult, jobFilter, criteriaQuery, count, predicates);

        pageCustomResult.setLength(count.intValue());
        pageCustomResult.setPageSize(jobFilter.getPageSize());
        pageCustomResult.setPageIndex(jobFilter.getPageIndex());

        return pageCustomResult;
    }

    private Predicate[] createRestrictions(JobFilter jobFilter, CriteriaBuilder criteriaBuilder,
                                           Root<JobEntity> root) {

        List<Predicate> predicateList = new ArrayList<>();

        if (jobFilter.getCategoryId() != null) {
            predicateList.add(criteriaBuilder.equal(root.get("category"), jobFilter.getCategoryId()));
        }

        if (!StringUtils.isBlank(jobFilter.getDescription())) {
            predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("description")),
                    "%" + jobFilter.getDescription().toLowerCase() + "%"));
        }

        if (jobFilter.getWeekendService() != null) {
            String weekendServiceFlag = jobFilter.getWeekendService() ? "S" : "N";
            predicateList.add(criteriaBuilder.equal(root.get("weekendService"), weekendServiceFlag));
        }

        if (jobFilter.getActive() != null) {
            String activeFlag = jobFilter.getWeekendService() ? "S" : "N";
            predicateList.add(criteriaBuilder.equal(root.get("active"), activeFlag));
        }

        return predicateList.toArray(new Predicate[predicateList.size()]);
    }

}
