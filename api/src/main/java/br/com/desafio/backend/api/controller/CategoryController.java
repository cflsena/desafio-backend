package br.com.desafio.backend.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.backend.api.controller.dto.CategoryRequest;
import br.com.desafio.backend.api.controller.dto.CategoryResponse;
import br.com.desafio.backend.api.entity.CategoryEntity;
import br.com.desafio.backend.api.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Retornar uma lista com todas as categorias cadastradas", description = "", tags = {
			"category" })
	public List<CategoryResponse> getAllCategory() {
		List<CategoryEntity> categories = getService().findAll();
		List<CategoryResponse> categoriesResponse = new ArrayList<CategoryResponse>();
		categories.forEach(category -> {
			CategoryResponse response = CategoryResponse.getInstance();
			getModelMapper().map(category, response);
			categoriesResponse.add(response);
		});
		return categoriesResponse;
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Retornar uma categoria cadastrada pelo id", description = "", tags = { "category" })
	public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable("id") Long id) {
		Optional<CategoryEntity> op = getService().findById(id);
		if (op.isPresent()) {
			CategoryEntity foundEntity = op.get();
			CategoryResponse categoryResponse = CategoryResponse.getInstance();
			getModelMapper().map(foundEntity, categoryResponse);
			return ResponseEntity.ok(categoryResponse);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Criar uma nova cateogria", description = "", tags = { "category" })
	public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest category) {

		CategoryEntity categoryToSave = CategoryEntity.getInstance();
		CategoryResponse categoryResponse = CategoryResponse.getInstance();

		getModelMapper().map(category, categoryToSave);
		Object ojb = getService().save(categoryToSave);
		CategoryEntity categoryCreated = (CategoryEntity) ojb;
		getModelMapper().map(categoryCreated, categoryResponse);

		return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Atualizar a descrição da categoria pelo id", description = "", tags = { "category" })
	public ResponseEntity<CategoryResponse> updateCategory(@PathVariable("id") Long id,
			@Valid @RequestBody CategoryRequest category) {
		CategoryEntity categoryToUpdate = CategoryEntity.getInstance();
		CategoryResponse categoryResponse = CategoryResponse.getInstance();
		getModelMapper().map(category, categoryToUpdate);
		Object obj = getService().update(categoryToUpdate, id);
		CategoryEntity categoryUpdated = (CategoryEntity) obj;
		getModelMapper().map(categoryUpdated, categoryResponse);
		return ResponseEntity.ok(categoryResponse);
	}

	private ModelMapper getModelMapper() {
		return modelMapper;
	}

	private CategoryService getService() {
		return this.categoryService;
	}

}
