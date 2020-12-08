package br.com.desafio.backend.api.controller.dto;

import br.com.desafio.backend.api.entity.CategoryEntity;
import br.com.desafio.backend.api.entity.ProfessionalEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest implements Serializable {

    private static final long serialVersionUID = 7534012000672630405L;
    private ProfessionalEntity professional;
    private CategoryEntity category;
    private String description;
    private Boolean weekendService;
    private Boolean active;
    private String references;

}
