package com.agendaatlas.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desativa proteção CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // libera tudo temporariamente
                        .anyRequest().authenticated());
        return http.build();
    }
}
