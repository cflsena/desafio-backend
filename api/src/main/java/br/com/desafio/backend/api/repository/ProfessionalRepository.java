package br.com.desafio.backend.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.backend.api.entity.ProfessionalEntity;

@Repository
public interface ProfessionalRepository extends JpaRepository<ProfessionalEntity, Long> {
    Optional<ProfessionalEntity> findByCellPhoneOrEmail(String cellPhone, String email);
}
