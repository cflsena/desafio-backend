package br.com.desafio.backend.api.service.common.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<Entity extends Object, ID extends Serializable> {

	List<Entity> findAll();

	Optional<Entity> findById(ID id);

	Object save(Entity entity);

	Object update(Entity entity, ID id);

	void deleteById(ID id);

	JpaRepository<Entity, ID> getRepository();

}
