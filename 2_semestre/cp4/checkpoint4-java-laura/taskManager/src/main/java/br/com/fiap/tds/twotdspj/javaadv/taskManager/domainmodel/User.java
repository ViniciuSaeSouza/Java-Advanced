package br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.util.*;

@Entity
@Table(name="USERS")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @NotBlank(message = "O nome do usuário é obrigatório")
    @Size(max = 100, message = "O nome deve conter no máximo 100 caracteres")
    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @NotBlank(message = "O endereço de email é obrigatório")
    @Email(message = "Informe um email válido")
    @Size(max = 100, message = "O email deve conter no máximo 100 caracteres")
    @Column(name = "email_addr", nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve conter pelo menos 6 caracteres")
    @Column(name = "user_password", nullable = false)
    private String password;

    public static User createNewUser(String userName, String userEmail, String userPassword) {
        return User.builder()
                .name(userName)
                .email(userEmail)
                .password(userPassword)
                .build();
    }

    public boolean hasValidCredentials() {
        return this.email != null && !this.email.trim().isEmpty()
            && this.password != null && !this.password.trim().isEmpty();
    }


    public void updateUserInfo(String newName, String newEmail) {
        this.name = newName;
        this.email = newEmail;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }
}