package com.agendaatlas.documentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendaatlas.documentos.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}
