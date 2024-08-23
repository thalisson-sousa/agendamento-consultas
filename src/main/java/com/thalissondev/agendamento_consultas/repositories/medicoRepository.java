package com.thalissondev.agendamento_consultas.repositories;

import com.thalissondev.agendamento_consultas.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface medicoRepository extends JpaRepository<Medico, Long> {
}
