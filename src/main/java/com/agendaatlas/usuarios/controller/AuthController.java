package com.agendaatlas.usuarios.controller;

import com.agendaatlas.exception.ErrorResponse;
import com.agendaatlas.exception.ResourceNotFoundException;
import com.agendaatlas.usuarios.dto.RegisterRequest;
import com.agendaatlas.usuarios.model.User;
import com.agendaatlas.usuarios.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/list")
    public ResponseEntity<List<User>> listarPacientes() {
        return ResponseEntity.ok(userService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(e.getMessage()));
        }
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
