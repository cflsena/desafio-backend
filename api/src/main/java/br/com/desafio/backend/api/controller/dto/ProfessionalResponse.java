package br.com.desafio.backend.api.controller.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class ProfessionalResponse implements Serializable {

	private static final long serialVersionUID = 5514262027028063685L;

	public static ProfessionalResponse getInstance() {
		return new ProfessionalResponse();
	}

	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String email;
	@Getter
	@Setter
	private String cellPhone;

}
