package br.com.desafio.backend.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.backend.api.entity.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, Long> {

	
}
