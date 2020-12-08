package br.com.desafio.backend.api.controller.dto;

import br.com.desafio.backend.api.entity.CategoryEntity;
import br.com.desafio.backend.api.entity.ProfessionalEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest implements Serializable {

    private static final long serialVersionUID = 7534012000672630405L;

    @Schema(description = "Identificador único para o Profissional relacionado ao serviço", example = "1", required = true)
    @NotNull
    private ProfessionalEntity professional;

    @Schema(description = "Identificador único para a Categoria relacionada ao serviço", example = "1", required = true)
    @NotNull
    private CategoryEntity category;

    @Schema(description = "Campo texto para a descrição do serviço", example = "Manutenção de Computadores", required = true)
    @NotBlank
    private String description;

    @Schema(description = "Campo booleano para indicar se o serviço é prestado aos fins de semana", example = "false", required = true)
    @NotNull
    private Boolean weekendService;

    @Schema(description = "Campo booleano para indicar que o serviço está ativo", example = "true", required = true)
    @NotNull
    private Boolean active;

    @Schema(description = "Campo texto para que indica referências do serviço", example = "true")
    private String references;

}
