package com.agendaatlas.usuarios.controller;

import com.agendaatlas.shared.JwtService;
import com.agendaatlas.usuarios.model.User;
import com.agendaatlas.usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        userRepository.save(user);
        return "Usuário registrado com sucesso!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        var auth = new UsernamePasswordAuthenticationToken(
                user.getEmail(), user.getSenha());
        authManager.authenticate(auth);
        User userAutenticado = userRepository.findByEmail(user.getEmail()).get();
        return jwtService.generateToken(userAutenticado.getEmail());
    }

}