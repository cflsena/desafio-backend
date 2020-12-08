package br.com.desafio.backend.api.validation.common;

import java.util.Optional;

public final class ValidationHelper {

    private static final ValidationResult validResult = new ValidationResult() {
        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public Optional<String> getReason() {
            return Optional.empty();
        }
    };

    public static ValidationResult getValidResult(){
        return validResult;
    }
}
