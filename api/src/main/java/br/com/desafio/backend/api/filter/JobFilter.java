package br.com.desafio.backend.api.filter;

import br.com.desafio.backend.api.repository.custom.paginator.PaginationCustom;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "Identificador único para o Profissional relacionado ao serviço", example = "1", required = true)
    private Long categoryId;

    @Schema(description = "Campo texto para a descrição do serviço", example = "Manutenção de Computadores", required = true)
    private String description;

    @Schema(description = "Campo booleano para indicar se o serviço é prestado aos fins de semana", example = "false", required = true)
    private Boolean weekendService;

    @Schema(description = "Campo booleano para indicar que o serviço está ativo", example = "true", required = true)
    private Boolean active;
}
