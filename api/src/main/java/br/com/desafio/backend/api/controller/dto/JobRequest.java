package br.com.desafio.backend.api.controller.dto;

import br.com.desafio.backend.api.entity.CategoryEntity;
import br.com.desafio.backend.api.entity.ProfessionalEntity;
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

    @NotNull
    private ProfessionalEntity professional;

    @NotNull
    private CategoryEntity category;

    @NotBlank
    private String description;

    @NotNull
    private Boolean weekendService;

    @NotNull
    private Boolean active;
    private String references;

}
