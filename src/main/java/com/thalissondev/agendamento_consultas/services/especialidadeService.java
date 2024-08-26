package com.thalissondev.agendamento_consultas.services;

import com.thalissondev.agendamento_consultas.dto.especialidadeDTO;
import com.thalissondev.agendamento_consultas.entities.Especialidade;
import com.thalissondev.agendamento_consultas.repositories.especialidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class especialidadeService {
    @Autowired
    private especialidadeRepository repository;

    @Transactional
    public Page<especialidadeDTO> getEspecialidades(Pageable pageable) {
        Page<especialidadeDTO> pacientes = this.repository.findAll(pageable).map(x -> new especialidadeDTO(x));
        return pacientes;
    }

    @Transactional
    public especialidadeDTO getPEspecialidade(Long id) {
        Especialidade Paciente = this.repository.getReferenceById(id);
        return new especialidadeDTO(Paciente);
    }

    @Transactional
    public void addEspecialidade(Especialidade Paciente) {
        this.repository.save(Paciente);
    }

    @Transactional
    public especialidadeDTO updateEspecialidade(Long id, Especialidade especialidade) {
        Especialidade refPaciente = this.repository.getReferenceById(id);
        especialidade.setId(refPaciente.getId());
        this.repository.save(especialidade);
        return new especialidadeDTO(especialidade);
    }

    @Transactional
    public void removeEspecialidade(Long id) {
        this.repository.deleteById(id);
    }
}
