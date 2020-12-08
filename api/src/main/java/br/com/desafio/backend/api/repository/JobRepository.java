package br.com.desafio.backend.api.repository;

import br.com.desafio.backend.api.entity.CategoryEntity;
import br.com.desafio.backend.api.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long> {
    Optional<JobEntity> findByCategory(CategoryEntity category);
}
