package br.com.fiap.tds.twotdspj.javaadv.taskManager.infrastructure.runner;

import br.com.fiap.tds.twotdspj.javaadv.taskManager.datasource.repository.UserRepository;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRunner {
    @Bean
    CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {
            User user1 = User.builder()
                    .name("Amanda Costa")
                    .email("amanda.costa@empresa.com")
                    .password("amanda789@")
                    .build();

            User user2 = User.builder()
                    .name("Rafael Sousa")
                    .email("rafael.sousa@tech.com")
                    .password("rafa@tech2024")
                    .build();

            User user3 = User.builder()
                    .name("Carla Mendes")
                    .email("carla.mendes@gmail.com")
                    .password("carla@456#")
                    .build();

            User user4 = User.builder()
                    .name("Diego Barbosa")
                    .email("diego.barbosa@outlook.com")
                    .password("diego#2023!")
                    .build();

            User user5 = User.builder()
                    .name("Fernanda Lima")
                    .email("fernanda.lima@hotmail.com")
                    .password("fernanda@987")
                    .build();

            User user6 = User.builder()
                    .name("Ana Carolina Silva")
                    .email("ana.carolina@example.com")
                    .password("anasilva456")
                    .build();

            User user7 = User.builder()
                    .name("Felipe Rodrigues")
                    .email("felipe.rodrigues@example.com")
                    .password("felipe@789")
                    .build();

            User user8 = User.builder()
                    .name("Camila Ferreira")
                    .email("camila.ferreira@example.com")
                    .password("cam@2024")
                    .build();

            User user9 = User.builder()
                    .name("Gabriel Costa")
                    .email("gabriel.costa@example.com")
                    .password("gabriel123!")
                    .build();

            User user10 = User.builder()
                    .name("Larissa Nunes")
                    .email("larissa.nunes@example.com")
                    .password("larissa@456")
                    .build();

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);
            userRepository.save(user5);
            userRepository.save(user6);
            userRepository.save(user7);
            userRepository.save(user8);
            userRepository.save(user9);
            userRepository.save(user10);

            System.out.println("10 usuários cadastrados com sucesso!");
        };
    }
}