package br.com.desafio.backend.api.service.common.interfaces;

import java.io.Serializable;
import java.util.Optional;

public interface RuleService <Entity extends Object, ID extends Serializable>{

	void validateEntity(Optional<Entity> op, Entity entity);
	void validateEntity(Optional<Entity> op);
	
}
