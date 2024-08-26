package com.thalissondev.agendamento_consultas.services;

import com.thalissondev.agendamento_consultas.dto.medicoDTO;
import com.thalissondev.agendamento_consultas.entities.Medico;
import com.thalissondev.agendamento_consultas.repositories.medicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class medicoService {
    @Autowired
    private medicoRepository repository;

    @Transactional
    public Page<medicoDTO> getMedicos(Pageable pageable) {
        Page<medicoDTO> medicos = this.repository.findAll(pageable).map(x -> new medicoDTO(x));
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
