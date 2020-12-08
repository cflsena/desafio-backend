package br.com.desafio.backend.api.controller.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse implements Serializable {

	private static final long serialVersionUID = -7839823974724928058L;

	public static CategoryResponse getInstance() {
		return new CategoryResponse();
	}

	private Long id;

	@Schema(description = "Campo texto para a descrição da categoria", example = "Beleza", required = true)
	@NotBlank
	private String description;

}
