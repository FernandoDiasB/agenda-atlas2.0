package com.agendaatlas.usuarios.controller;

import com.agendaatlas.usuarios.dto.RegisterRequest;
import com.agendaatlas.usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterRequest request) {
        return userService.login(request);
    }

    @GetMapping("/token")
    public String getToken() {
        return "Token de teste: " + userService.login(
                new RegisterRequest("usuario@example.com", "senha123"));
    }
}
