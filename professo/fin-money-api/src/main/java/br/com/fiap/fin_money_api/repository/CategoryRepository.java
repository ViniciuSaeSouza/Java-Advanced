package br.com.fiap.fin_money_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.fin_money_api.model.Category;
import br.com.fiap.fin_money_api.model.User;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByUser(User user);
    
}
