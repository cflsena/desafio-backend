package br.com.desafio.backend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.backend.api.entity.ProfessionalEntity;

public interface ProfessionalRepository extends JpaRepository<ProfessionalEntity, Long> {

}
