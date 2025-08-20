package br.com.fiap._tdspj.Library.presentation.controllers;

import br.com.fiap._tdspj.Library.domain.model.Category;
import br.com.fiap._tdspj.Library.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryControllers {
    private CategoryService _categoryService;

    public CategoryControllers(CategoryService categoryService) {
        this._categoryService = categoryService;
    }

    @GetMapping("/listAll")
    public String fetchAll(Model model){
        List<Category> categories = Collections.emptyList();
        categories.addAll(_categoryService.findAll());
        model.addAttribute("categories", categories);
        return  "crud_do_category";
    }
}
