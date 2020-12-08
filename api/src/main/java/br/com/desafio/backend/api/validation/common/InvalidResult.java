package br.com.desafio.backend.api.validation.common;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@EqualsAndHashCode(of = "reason")
@AllArgsConstructor
public class InvalidResult implements ValidationResult {

    private String reason;

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public Optional<String> getReason() {
        return Optional.of(this.reason);
    }

}
