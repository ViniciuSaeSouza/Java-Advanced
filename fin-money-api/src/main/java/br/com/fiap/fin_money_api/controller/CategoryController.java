package br.com.fiap.fin_money_api.controller;

import br.com.fiap.fin_money_api.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

	private List<Category> repository = new ArrayList<>();

	
	//Toda anotação possui um atributo padrão, neste caso, quando for passar apenas o atributo padrão, não é necessario identificar o atributo
	@GetMapping("/categories")
	// Quando devolvemos um objeto, automaticamente ele irá retornar um JSON
	public List<Category> index(){
		return repository;
	}

	@PostMapping("/categories")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Category create(@RequestBody Category category){
		System.out.println("Nome da categoria: "+ category.getName());
		repository.add(category);
		return category;
	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> get(@PathVariable Long id){
		// 1L -> o L representa um Long
		System.out.println("buscando categoria: " + id);
		Optional<Category>  first = repository.stream()
			.filter(c -> c.getId().equals(id))
			.findFirst();

		if (first.isEmpty()){
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(first.get());
		
	}
}
