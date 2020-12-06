package br.com.desafio.backend.api.service.common;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafio.backend.api.service.common.interfaces.GenericService;
import br.com.desafio.backend.api.service.common.interfaces.RuleService;

public abstract class GenericServiceAbstract<Entity extends Object, ID extends Serializable>
		implements GenericService<Entity, ID>, RuleService<Entity, ID> {

	@Transactional(readOnly = true)
	@Override
	public List<Entity> findAll() {
		return getRepository().findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Entity> findById(ID id) {
		return (Optional<Entity>) getRepository().findById(id);
	}

	@Override
	public Object save(Entity entity) {
		entity = getRepository().save(entity);
		getRepository().flush();
		return entity;
	}

	@Override
	public Object update(Entity entity, ID id) {
		Optional<Entity> op = (Optional<Entity>) getRepository().findById(id);
		validateEntity(op, entity);
		Entity foundEntity = op.get();
		BeanUtils.copyProperties(entity, foundEntity, "id");
		foundEntity = getRepository().save(foundEntity);
		getRepository().flush();
		return foundEntity;
	}

	@Transactional
	@Override
	public void deleteById(ID id) {
		getRepository().deleteById(id);
		getRepository().flush();

	}

	@Override
	public void validateEntity(Optional<Entity> op, Entity entity) {
		if (!op.isPresent() || entity == null) {
			throw new EmptyResultDataAccessException(1);
		}
	}

	@Override
	public void validateEntity(Optional<Entity> op) {
		if (!op.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
	}

}
