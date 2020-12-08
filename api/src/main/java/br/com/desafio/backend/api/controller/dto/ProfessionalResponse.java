package br.com.desafio.backend.api.controller.dto;

import java.io.Serializable;

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
public class ProfessionalResponse implements Serializable {

	private static final long serialVersionUID = 5514262027028063685L;

	public static ProfessionalResponse from(final ProfessionalEntity entity) {
		return create(entity.getName(), entity.getEmail(), entity.getCellPhone());
	}

	@Schema(description = "Campo texto para o nome completo do profissional", example = "Fulano Beltrano", required = true)
	private String name;

	@Schema(description = "Campo texto para o email do profissional", example = "teste@teste.com", required = true)
	private String email;

	@Schema(description = "Campo texto (porém, apenas números) para o celular do profissional", example = "12345678910", required = true)
	private String cellPhone;

}
