package br.com.desafio.backend.api.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor(staticName = "create")
@AllArgsConstructor(staticName = "create")
public class JobStatusRequest implements Serializable {
    private static final long serialVersionUID = 4901565620249501533L;

    @NotNull
    @Schema(description = "Campo booleano para indicar que o serviço está ativo", example = "true", required = true)
    private Boolean active;

}
