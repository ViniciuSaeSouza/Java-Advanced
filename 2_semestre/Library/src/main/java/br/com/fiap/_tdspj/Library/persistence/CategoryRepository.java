package br.com.fiap._tdspj.Library.persistence;

import br.com.fiap._tdspj.Library.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
