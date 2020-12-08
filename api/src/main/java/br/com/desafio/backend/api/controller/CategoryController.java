package br.com.desafio.backend.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
	private CategoryService categoryService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Retornar uma lista com todas as categorias cadastradas", description = "", tags = {
			"category" })
	public List<CategoryResponse> getAllCategory() {
		List<CategoryEntity> categories = getService().findAll();
		return categories.stream().map(CategoryResponse::from).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Retornar uma categoria cadastrada pelo id", description = "", tags = { "category" })
	public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable("id") Long id) {
		Optional<CategoryEntity> op = getService().findById(id);
		if (op.isPresent()) {
			CategoryEntity foundEntity = op.get();
			CategoryResponse categoryResponse = CategoryResponse.from(foundEntity);
			return ResponseEntity.ok(categoryResponse);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Criar uma nova cateogria", description = "", tags = { "category" })
	public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest category) {

		CategoryEntity categoryToSave = CategoryEntity.create();
		CategoryResponse categoryResponse = CategoryResponse.create();

		categoryToSave.setDescription(category.getDescription());
		Object ojb = getService().save(categoryToSave);
		CategoryEntity categoryCreated = (CategoryEntity) ojb;
		categoryResponse = CategoryResponse.from(categoryCreated);

		return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Atualizar a descrição da categoria pelo id", description = "", tags = { "category" })
	public ResponseEntity<CategoryResponse> updateCategory(@PathVariable("id") Long id,
			@Valid @RequestBody CategoryRequest category) {
		CategoryEntity categoryToUpdate = CategoryEntity.create();
		CategoryResponse categoryResponse = CategoryResponse.create();
		categoryToUpdate.setDescription(category.getDescription());
		Object obj = getService().update(categoryToUpdate, id);
		CategoryEntity categoryUpdated = (CategoryEntity) obj;
		categoryResponse = CategoryResponse.from(categoryUpdated);
		return ResponseEntity.ok(categoryResponse);
	}

	private CategoryService getService() {
		return this.categoryService;
	}

}
