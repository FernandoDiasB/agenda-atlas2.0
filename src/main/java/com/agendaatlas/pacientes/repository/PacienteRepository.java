package com.agendaatlas.pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendaatlas.pacientes.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
