package com.thalissondev.agendamento_consultas.repositories;

import com.thalissondev.agendamento_consultas.entities.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface especialidadeRepository extends JpaRepository<Especialidade, Long> {
}
