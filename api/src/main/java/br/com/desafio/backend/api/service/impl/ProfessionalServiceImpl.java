package br.com.desafio.backend.api.service.impl;

import br.com.desafio.backend.api.entity.ProfessionalEntity;
import br.com.desafio.backend.api.exception.custom.BadRequestException;
import br.com.desafio.backend.api.exception.custom.UniqueConstraintException;
import br.com.desafio.backend.api.repository.ProfessionalRepository;
import br.com.desafio.backend.api.service.ProfessionalService;
import br.com.desafio.backend.api.service.common.GenericServiceAbstract;
import br.com.desafio.backend.api.validation.ProfessionalValidator;
import br.com.desafio.backend.api.validation.common.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessionalServiceImpl extends GenericServiceAbstract<ProfessionalEntity, Long>
        implements ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Override
    public JpaRepository<ProfessionalEntity, Long> getRepository() {
        return this.professionalRepository;
    }


    @Override
    public ProfessionalEntity createProfessional(ProfessionalEntity professional) {
        validateProfessionalConstraints(professional);
        validateProfessionalProperties(professional);
        Object obj = getRepository().save(professional);
        return (ProfessionalEntity) obj;
    }

    private void validateProfessionalConstraints(ProfessionalEntity professional) {
        Optional<ProfessionalEntity> optProfessional = professionalRepository
                .findByCellPhoneOrEmail(professional.getCellPhone(), professional.getEmail());
        if (optProfessional.isPresent()) {
            ProfessionalEntity foundProfessional = optProfessional.get();
            if (professional.getCellPhone().equals(foundProfessional.getCellPhone())) {
                throw new UniqueConstraintException("Este número de celular já está cadastrado");
            }
            if (professional.getEmail().equals(foundProfessional.getEmail())) {
                throw new UniqueConstraintException("Este email já está cadastrado");
            }
        }
    }

    private void validateProfessionalProperties(ProfessionalEntity professional) {
        ValidationResult result = ProfessionalValidator.emailContainsAtSign()
                .and(ProfessionalValidator.cellPhoneContainsOnlyNumbers())
                .and(ProfessionalValidator.cellPhoneHasAValidLength()).apply(professional);
        if (result.getReason().isPresent()) {
            throw new BadRequestException(result.getReason().get());
        }
    }
}
