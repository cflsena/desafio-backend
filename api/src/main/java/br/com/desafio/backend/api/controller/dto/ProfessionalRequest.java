package br.com.desafio.backend.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalRequest implements Serializable {

	private static final long serialVersionUID = 5676116390421714288L;

	private String name;
	private String email;
	private String cellPhone;
}
