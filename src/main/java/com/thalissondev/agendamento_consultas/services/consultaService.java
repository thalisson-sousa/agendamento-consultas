package com.thalissondev.agendamento_consultas.services;

import com.thalissondev.agendamento_consultas.dto.consultaDTO;
import com.thalissondev.agendamento_consultas.entities.Consulta;
import com.thalissondev.agendamento_consultas.repositories.consultaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class consultaService {
    @Autowired
    private consultaRepository repository;

    @Transactional
    public Page<consultaDTO> getConsultas(Pageable pageable) {
        Page<consultaDTO> consultas = this.repository.findAll(pageable).map(x -> new consultaDTO(x));
        return consultas;
    }

    @Transactional
    public consultaDTO getConsultaById(Long id){
        Consulta consulta = this.repository.getReferenceById(id);
        return new consultaDTO(consulta);
    }

    @Transactional
    public void addConsulta(Consulta consulta) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        consulta.setData(dateFormat.format(date));
        this.repository.save(consulta);
    }

    @Transactional
    public consultaDTO updateConsulta(Long id, Consulta consulta) {
        Consulta refMedico = this.repository.getReferenceById(id);
        consulta.setId(refMedico.getId());
        this.repository.save(consulta);
        return new consultaDTO(consulta);
    }

    @Transactional
    public void removeConsulta(Long id) {
        this.repository.deleteById(id);
    }
}
