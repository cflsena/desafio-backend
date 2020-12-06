package br.com.desafio.backend.api.exception.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ApiSubError {
	private String object;
	private String field;
	private Object rejectedValue;
	private String userMessage;

	public ApiSubError(String object, String userMessage) {
		this.object = object;
		this.userMessage = userMessage;
	}
}
