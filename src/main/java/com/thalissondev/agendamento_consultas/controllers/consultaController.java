package com.thalissondev.agendamento_consultas.controllers;

import com.thalissondev.agendamento_consultas.dto.consultaDTO;
import com.thalissondev.agendamento_consultas.entities.Consulta;
import com.thalissondev.agendamento_consultas.services.consultaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "gdc/consulta")
public class consultaController {
    @Autowired
    private consultaService service;

    @Transactional
    @GetMapping
    public ResponseEntity<Page<consultaDTO>> getMedicos(Pageable pageable) {
        return ResponseEntity.ok().body(this.service.getConsultas(pageable));
    }

    @Transactional
    @GetMapping(value = "/{id}")
    public ResponseEntity<consultaDTO> getMedicoById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.service.getConsultaById(id));
    }

    @PostMapping
    public ResponseEntity createMedico(@RequestBody Consulta consulta) {
        this.service.addConsulta(consulta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(consulta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<consultaDTO> updateMedico(@PathVariable Long id, @RequestBody Consulta consulta) {
        consultaDTO medico = this.service.updateConsulta(id, consulta);
        return ResponseEntity.ok().body(medico);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteMedico(@PathVariable Long id) {
        this.service.removeConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
