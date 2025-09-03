package br.com.fiap.tds.twotdspj.javaadv.taskManager.controllers;

import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.User;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService _userService;

    public UserController(UserService userService) {
        this._userService = userService;
    }

    @GetMapping
    public String GetUsers(Model model) {
        model.addAttribute("users", _userService.findAll());
        return "users/list";
    }
}
