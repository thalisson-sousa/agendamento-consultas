package com.thalissondev.agendamento_consultas.services;

import com.thalissondev.agendamento_consultas.dto.medicoDTO;
import com.thalissondev.agendamento_consultas.entities.Medico;
import com.thalissondev.agendamento_consultas.repositories.medicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class medicoService {
    @Autowired
    private medicoRepository repository;

    @Transactional
    public List<medicoDTO> getMedicos() {
        List<medicoDTO> medicos = this.repository.findAll().stream().map(x -> new medicoDTO(x)).toList();
        return medicos;
    }

    @Transactional
    public medicoDTO getMedicoById(Long id){
        Medico Medico = this.repository.getReferenceById(id);
        return new medicoDTO(Medico);
    }

    @Transactional
    public void addMedico(Medico Medico) {
        this.repository.save(Medico);
    }

    @Transactional
    public medicoDTO updateMedico(Long id, Medico Medico) {
        com.thalissondev.agendamento_consultas.entities.Medico refMedico = this.repository.getReferenceById(id);
        Medico.setId(refMedico.getId());
        this.repository.save(Medico);
        return new medicoDTO(Medico);
    }

    @Transactional
    public void removeMedico(Long id) {
        this.repository.deleteById(id);
    }
}
