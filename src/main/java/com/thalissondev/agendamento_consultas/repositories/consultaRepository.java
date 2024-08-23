package com.thalissondev.agendamento_consultas.repositories;

import com.thalissondev.agendamento_consultas.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface consultaRepository extends JpaRepository<Consulta, Long> {
}
