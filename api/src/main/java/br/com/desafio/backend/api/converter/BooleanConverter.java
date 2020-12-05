package br.com.desafio.backend.api.converter;

import javax.persistence.AttributeConverter;

public class BooleanConverter implements AttributeConverter<Boolean, String> {
	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		if (attribute == null)
			return null;
		return (attribute) ? "S" : "N";
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		return "S".equalsIgnoreCase(dbData);
	}
}
