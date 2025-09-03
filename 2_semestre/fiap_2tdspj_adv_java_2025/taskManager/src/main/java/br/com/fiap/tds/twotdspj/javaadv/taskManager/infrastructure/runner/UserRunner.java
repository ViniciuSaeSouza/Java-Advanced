package br.com.fiap.tds.twotdspj.javaadv.taskManager.infrastructure.runner;

import br.com.fiap.tds.twotdspj.javaadv.taskManager.datasource.repository.TaskRepository;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.datasource.repository.UserRepository;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.Task;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.TaskPriority;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.TaskStatus;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class UserRunner {
    @Bean
    CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {
            User user1 = new User();
            user1.setName("Alice Silva");
            user1.setEmail("alice.silva@example.com");
            user1.setPassword("123456");

            User user2 = new User();
            user2.setName("Bruno Costa");
            user2.setEmail("bruno.costa@example.com");
            user2.setPassword("senhaSegura");

            User user3 = new User();
            user3.setName("Carla Souza");
            user3.setEmail("carla.souza@example.com");
            user3.setPassword("qwerty123");

            User user4 = new User();
            user4.setName("Diego Ferreira");
            user4.setEmail("diego.ferreira@example.com");
            user4.setPassword("minhaSenha");

            User user5 = new User();
            user5.setName("Fernanda Lima");
            user5.setEmail("fernanda.lima@example.com");
            user5.setPassword("abc12345");

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);
            userRepository.save(user5);

            System.out.println("Usuários cadastrados com sucesso!");
        };
    }
}

