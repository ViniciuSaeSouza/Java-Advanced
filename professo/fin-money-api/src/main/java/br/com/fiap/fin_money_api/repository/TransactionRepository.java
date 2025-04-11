package br.com.fiap.fin_money_api.repository;

import br.com.fiap.fin_money_api.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, JPA {

    //SELECT * FROM transaction WHERE description =: description
    //@Query("SELECT t FROM transaction as t WHERE t.description =: description") //JPQL


}
