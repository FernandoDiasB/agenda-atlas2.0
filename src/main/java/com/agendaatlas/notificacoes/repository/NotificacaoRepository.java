package com.agendaatlas.notificacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendaatlas.notificacoes.model.Notificacao;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

}
