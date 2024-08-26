package com.thalissondev.agendamento_consultas.services;

import com.thalissondev.agendamento_consultas.dto.pacienteDTO;
import com.thalissondev.agendamento_consultas.entities.Paciente;
import com.thalissondev.agendamento_consultas.repositories.pacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class pacienteService {
    @Autowired
    private pacienteRepository repository;

    public Page<pacienteDTO> getPacientes(Pageable pageable) {
        Page<pacienteDTO> pacientes = this.repository.findAll(pageable).map(x -> new pacienteDTO(x));
        return pacientes;
    }

    @Transactional
    public pacienteDTO getPaciente(Long id) {
        Paciente Paciente = this.repository.getReferenceById(id);
        return new pacienteDTO(Paciente);
    }

    public void addPaciente(Paciente Paciente) {
        this.repository.save(Paciente);
    }

    @Transactional
    public pacienteDTO updatePaciente(Long id, Paciente Paciente) {
        com.thalissondev.agendamento_consultas.entities.Paciente refPaciente = this.repository.getReferenceById(id);
        Paciente.setId(refPaciente.getId());
        this.repository.save(Paciente);
        return new pacienteDTO(Paciente);
    }

    public void removePaciente(Long id) {
        this.repository.deleteById(id);
    }
}
