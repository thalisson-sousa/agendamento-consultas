package com.thalissondev.agendamento_consultas.repositories;

import com.thalissondev.agendamento_consultas.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pacienteRepository extends JpaRepository<Paciente, Long> {
}
