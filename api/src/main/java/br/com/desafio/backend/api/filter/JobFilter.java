package br.com.desafio.backend.api.filter;

import br.com.desafio.backend.api.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobFilter implements Serializable {
    private static final long serialVersionUID = 1865432684532L;

    private Long id;
    private CategoryEntity category;
    private String description;
    private Boolean weekendService;
    private Boolean active;
}
