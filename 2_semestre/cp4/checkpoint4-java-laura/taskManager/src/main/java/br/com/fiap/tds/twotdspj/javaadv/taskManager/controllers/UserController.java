package br.com.fiap.tds.twotdspj.javaadv.taskManager.controllers;

import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.DTOs.UserUpdateDTO;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.User;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", User.builder().build());
        return "users/form";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user,
                          BindingResult bindingResult,
                          Model model,
                          RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "users/form";
        }

        try {
            User savedUser = userService.save(user);
            redirectAttributes.addFlashAttribute("successMessage",
                "Usuário " + savedUser.getName() + " criado com sucesso!");
            return "redirect:/users";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Erro ao criar usuário: " + e.getMessage());
            return "users/form";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") UUID id,
                            RedirectAttributes redirectAttributes) {
        try {
            if (userService.existsById(id)) {
                userService.deleteById(id);
                redirectAttributes.addFlashAttribute("successMessage", "Usuário removido com sucesso!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Usuário não encontrado!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao remover usuário!");
        }
        return "redirect:/users";
    }

    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable("id") UUID id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));
        model.addAttribute("user", user);
        return "users/view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") UUID id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));
        model.addAttribute("user", user);
        return "users/form";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") UUID id,
                            @Valid @ModelAttribute("user") UserUpdateDTO dto,
                            BindingResult bindingResult,
                            Model model,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "users/form";
        }

        try {
            User existingUser = userService.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));

            existingUser.updateUserInfo(dto.getName(), dto.getEmail());

            if (dto.hasNewPassword()) {
                existingUser.updatePassword(dto.getPassword());
            }

            userService.save(existingUser);
            redirectAttributes.addFlashAttribute("successMessage",
                "Usuário " + existingUser.getName() + " atualizado com sucesso!");

            return "redirect:/users";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Erro ao atualizar usuário: " + e.getMessage());
            return "users/form";
        }
    }
}
