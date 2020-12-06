package br.com.desafio.backend.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.desafio.backend.api.entity.CategoryEntity;
import br.com.desafio.backend.api.repository.CategoryRepository;
import br.com.desafio.backend.api.service.CategoryService;
import br.com.desafio.backend.api.service.common.GenericServiceAbstract;

@Service
public class CategoryServiceImpl extends GenericServiceAbstract<CategoryEntity, Long> implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public JpaRepository<CategoryEntity, Long> getRepository() {
		return categoryRepository;
	}

}
