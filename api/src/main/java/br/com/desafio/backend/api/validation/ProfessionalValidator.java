package br.com.desafio.backend.api.validation;

import br.com.desafio.backend.api.entity.ProfessionalEntity;
import br.com.desafio.backend.api.validation.common.ValidationResult;
import br.com.desafio.backend.api.validation.util.ValidationMessageConstant;

import java.util.function.Function;
import java.util.function.Predicate;

public interface ProfessionalValidator extends Function<ProfessionalEntity, ValidationResult> {

    static ProfessionalValidator emailContainsAtSign() {
        return verify(professionalEntity -> professionalEntity.getEmail().contains("@"), ValidationMessageConstant.INVALID_EMAIL);
    }

    static ProfessionalValidator cellPhoneHasAValidLength() {
        return verify(professionalEntity -> professionalEntity.getCellPhone().length() >= 10
                && professionalEntity.getCellPhone().length() <= 11, ValidationMessageConstant.INVALID_CELL_PHONE_LENGTH);
    }

    static ProfessionalValidator cellPhoneContainsOnlyNumbers() {
        return verify(professionalEntity -> professionalEntity.getCellPhone().matches("^[0-9]+$"), ValidationMessageConstant.INVALID_CELL_PHONE_FORMAT);
    }

    static ProfessionalValidator verify(Predicate<ProfessionalEntity> p, String message) {
        return user -> p.test(user) ? ValidationResult.valid() : ValidationResult.invalid(message);
    }

    default ProfessionalValidator and(ProfessionalValidator other) {
        return professionalEntity -> {
            ValidationResult result = this.apply(professionalEntity);
            return result.isValid() ? other.apply(professionalEntity) : result;
        };
    }
}
