package br.com.desafio.backend.api.controller.dto;

import java.io.Serializable;

import br.com.desafio.backend.api.entity.CategoryEntity;
import br.com.desafio.backend.api.entity.JobEntity;
import br.com.desafio.backend.api.entity.ProfessionalEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(staticName = "create")
public class JobResponse implements Serializable {

	private static final long serialVersionUID = -9134195187967739614L;

	public static JobResponse from(final JobEntity entity) {
		return create(entity.getProfessional(), entity.getCategory(), entity.getDescription(),
				entity.getWeekendService(), entity.getActive(), entity.getReferences());
	}

	@Schema(description = "Identificador único para o Profissional relacionado ao serviço", example = "1", required = true)
	private ProfessionalEntity professional;

	@Schema(description = "Identificador único para a Categoria relacionada ao serviço", example = "1", required = true)
	private CategoryEntity category;

	@Schema(description = "Campo texto para a descrição do serviço", example = "Manutenção de Computadores", required = true)
	private String description;

	@Schema(description = "Campo booleano para indicar se o serviço é prestado aos fins de semana", example = "false", required = true)
	private Boolean weekendService;

	@Schema(description = "Campo booleano para indicar que o serviço está ativo", example = "true", required = true)
	private Boolean active;

	@Schema(description = "Campo texto para que indica referências do serviço", example = "LinkedIn.com/meu-perfil")
	private String references;

}
