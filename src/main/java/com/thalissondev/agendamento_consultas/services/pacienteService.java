package com.thalissondev.agendamento_consultas.services;

import com.thalissondev.agendamento_consultas.dto.pacienteDTO;
import com.thalissondev.agendamento_consultas.entities.Paciente;
import com.thalissondev.agendamento_consultas.repositories.pacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pacienteService {
    @Autowired
    private pacienteRepository repository;

    public List<pacienteDTO> getPacientes() {
        List<pacienteDTO> pacientes = this.repository.findAll().stream().map(x -> new pacienteDTO(x)).toList();
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
