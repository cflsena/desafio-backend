package br.com.desafio.backend.api.validation.common;

import java.util.Optional;

public interface ValidationResult {

    static ValidationResult valid() {
        return ValidationHelper.getValidResult();
    }

    static ValidationResult invalid(String reason) {
        return new InvalidResult(reason);
    }

    boolean isValid();

    Optional<String> getReason();
}
