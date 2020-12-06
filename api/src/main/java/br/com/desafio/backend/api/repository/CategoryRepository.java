package br.com.desafio.backend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.backend.api.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
