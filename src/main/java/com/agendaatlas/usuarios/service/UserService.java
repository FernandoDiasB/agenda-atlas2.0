package com.agendaatlas.usuarios.service;

import com.agendaatlas.exception.ResourceNotFoundException;
import com.agendaatlas.shared.JwtService;
import com.agendaatlas.usuarios.dto.RegisterRequest;
import com.agendaatlas.usuarios.model.User;
import com.agendaatlas.usuarios.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtService jwtService;

    public String register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setSenha(passwordEncoder.encode(request.getSenha()));
        userRepository.save(user);
        return "Usuário registrado com sucesso!";
    }

    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o id " + id));
        userRepository.deleteById(id);

    }

    public String login(RegisterRequest request) {
        var auth = new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getSenha());

        authManager.authenticate(auth);

        return jwtService.generateToken(request.getEmail());
    }
}
