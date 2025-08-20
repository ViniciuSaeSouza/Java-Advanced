package br.com.fiap._tdspj.Library.service;

import br.com.fiap._tdspj.Library.persistence.CategoryRepository;
import lombok.experimental.Delegate;

public class CategoryService {
    @Delegate
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



}
