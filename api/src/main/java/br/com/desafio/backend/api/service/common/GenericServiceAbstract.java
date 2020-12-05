package br.com.desafio.backend.api.service.common;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;

import br.com.desafio.backend.api.service.common.interfaces.GenericService;

public abstract class GenericServiceAbstract<Entity extends Object, ID extends Serializable>
		implements GenericService<Entity, ID> {

	@Override
	public List<Entity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Entity> findById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object save(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update(Entity entity, ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(ID id) {
		// TODO Auto-generated method stub

	}

	private void validateEntity(Optional<Entity> op) {
		if (!op.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
	}

}
