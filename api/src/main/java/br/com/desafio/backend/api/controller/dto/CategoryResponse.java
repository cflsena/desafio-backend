package br.com.desafio.backend.api.controller.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.com.desafio.backend.api.entity.CategoryEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(staticName = "create")
@AllArgsConstructor(staticName = "create")
@Builder
public class CategoryResponse implements Serializable {

	private static final long serialVersionUID = -7839823974724928058L;

	public static CategoryResponse from(final CategoryEntity entity) {
		return CategoryResponse.builder()
				.id(entity.getId())
				.description(entity.getDescription())
				.build();
//		return CategoryResponse.create(entity.getId(), entity.getDescription());
	}

	private Long id;

	@Schema(description = "Campo texto para a descrição da categoria", example = "Beleza", required = true)
	@NotBlank
	private String description;

}
