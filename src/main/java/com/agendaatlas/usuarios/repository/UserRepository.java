package com.agendaatlas.usuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendaatlas.usuarios.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
