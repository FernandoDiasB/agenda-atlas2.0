package com.agendaatlas.pacientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.agendaatlas.pacientes.model.Paciente;
import com.agendaatlas.pacientes.service.PacienteService;

@CrossOrigin(origins = {"http://localhost:5500", "http://localhost:8080", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.criarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @DeleteMapping
    public ResponseEntity<String> deletarTodosPacientes() {
        try {
            long countAntes = pacienteService.contarPacientes();
            pacienteService.deletarTodos();
            long countDepois = pacienteService.contarPacientes();

            if (countDepois == 0) {
                return ResponseEntity.ok("Todos os " + countAntes + " pacientes foram removidos com sucesso.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Falha ao remover todos os pacientes.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao tentar remover pacientes: " + e.getMessage());
        }
    }
}
