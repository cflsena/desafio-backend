package br.com.desafio.backend.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalRequest implements Serializable {

	private static final long serialVersionUID = 5676116390421714288L;

	@NotBlank
	private String name;

	@NotBlank
	private String email;

	@Size(min = 11, max = 11)
	private String cellPhone;
}
