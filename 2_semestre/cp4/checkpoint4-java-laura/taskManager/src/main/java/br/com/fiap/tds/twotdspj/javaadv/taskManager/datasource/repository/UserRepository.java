package br.com.fiap.tds.twotdspj.javaadv.taskManager.datasource.repository;

import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.User;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Override
    @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
    List<User> findAll();

    @Query("SELECT u FROM User u WHERE u.email = :email")
    List<User> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.name = :name")
    Optional<User> findByName(@Param("name") String name);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.name LIKE %:pattern%")
    List<User> findByNameContaining(@Param("pattern") String namePattern);
}
