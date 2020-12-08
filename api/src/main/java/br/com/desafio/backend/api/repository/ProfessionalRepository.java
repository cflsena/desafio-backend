package br.com.desafio.backend.api.repository;

import br.com.desafio.backend.api.entity.ProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessionalRepository extends JpaRepository<ProfessionalEntity, Long> {
    Optional<ProfessionalEntity> findByCellPhoneOrEmail(String cellPhone, String email);
}
