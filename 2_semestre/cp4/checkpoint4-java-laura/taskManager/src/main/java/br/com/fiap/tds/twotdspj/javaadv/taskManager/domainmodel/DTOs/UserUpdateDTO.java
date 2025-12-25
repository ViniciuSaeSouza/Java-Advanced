package br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {

    private UUID id;

    @NotBlank(message = "O nome do usuário é obrigatório")
    @Size(max = 100, message = "O nome deve conter no máximo 100 caracteres")
    private String name;

    @NotBlank(message = "O endereço de email é obrigatório")
    @Email(message = "Informe um email válido")
    @Size(max = 100, message = "O email deve conter no máximo 100 caracteres")
    private String email;

    @Pattern(regexp = "^$|.{6,}", message = "A senha deve ter pelo menos 6 caracteres ou ficar vazia")
    private String password;

    public boolean hasNewPassword() {
        return this.password != null && !this.password.trim().isEmpty();
    }

    public static UserUpdateDTO createEmpty() {
        return UserUpdateDTO.builder().build();
    }

    public boolean isDataValid() {
        return name != null && !name.trim().isEmpty()
            && email != null && !email.trim().isEmpty();
    }
}
