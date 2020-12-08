package br.com.desafio.backend.api.repository.custom.common;

import br.com.desafio.backend.api.repository.custom.paginator.PageCustom;
import br.com.desafio.backend.api.repository.custom.paginator.PaginationCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public abstract class CustomRepositoryAbstract {

    @PersistenceContext
    protected EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected <T> Long count(Class<T> myClass, Predicate[] predicates) {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);
        Root<T> root = criteriaQueryCount.from(myClass);
        root.alias("root_alias");
        if (predicates.length > 0) {
            criteriaQueryCount.where(predicates);
        }
        criteriaQueryCount.select(criteriaBuilder.count(root));
        return this.getEntityManager().createQuery(criteriaQueryCount).getSingleResult();
    }

    protected void executeCriteriaQuery(PageCustom pageCustomResult, PaginationCustom filter,
                                        CriteriaQuery<?> criteriaQuery, Long count, Predicate[] predicates) {
        if (count > 0) {
            if (predicates.length > 0) {
                criteriaQuery.where(predicates);
            }
            TypedQuery<?> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
            this.setPagination(typedQuery, filter);
            pageCustomResult.setListObject(typedQuery.getResultList());
            return;
        }
        if (count <= 0) {
            pageCustomResult.setListObject(new ArrayList<>());
            return;
        }
    }

    private void setPagination(TypedQuery<?> query, PaginationCustom paginator) {
        query.setFirstResult(paginator.getPageIndex() * paginator.getPageSize());
        query.setMaxResults(paginator.getPageSize());
    }

}
