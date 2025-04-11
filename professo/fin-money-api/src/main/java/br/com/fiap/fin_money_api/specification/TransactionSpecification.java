package br.com.fiap.fin_money_api.specification;

import br.com.fiap.fin_money_api.controller.TransactionController;
import br.com.fiap.fin_money_api.model.Transaction;
import org.springframework.data.jpa.domain.Specification;

import java.util.function.Predicate;

public class TransactionSpecification {
    public static Specification<Transaction> withFilters(TransactionController.TransactionFilters filters) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("description"), filters.description());
        };
    }
}
