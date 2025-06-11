package com.agendaatlas.pacientes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agendaatlas.pacientes.model.Paciente;
import com.agendaatlas.pacientes.repository.PacienteRepository;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente criarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public void deletarTodos() {
        pacienteRepository.deleteAll();
    }

    public long contarPacientes() {
        return pacienteRepository.count();
    }

}
