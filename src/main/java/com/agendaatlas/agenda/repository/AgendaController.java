package com.agendaatlas.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendaatlas.agenda.model.Agenda;

public interface AgendaController extends JpaRepository<Agenda, Long> {

}
