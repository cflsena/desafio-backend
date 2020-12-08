package br.com.desafio.backend.api.filter;

import br.com.desafio.backend.api.repository.custom.paginator.PaginationCustom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobFilter extends PaginationCustom implements Serializable {
    private static final long serialVersionUID = 1865432684532L;

    private Long categoryId;
    private String description;
    private Boolean weekendService;
    private Boolean active;
}
