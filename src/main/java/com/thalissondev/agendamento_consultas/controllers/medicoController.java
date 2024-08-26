package com.thalissondev.agendamento_consultas.controllers;

import com.thalissondev.agendamento_consultas.dto.medicoDTO;
import com.thalissondev.agendamento_consultas.entities.Medico;
import com.thalissondev.agendamento_consultas.services.medicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "gdc/medico")
public class medicoController {

    @Autowired
    private medicoService service;

    @GetMapping
    public ResponseEntity<Page<medicoDTO>> getMedicos(Pageable pageable) {
        return ResponseEntity.ok().body(this.service.getMedicos(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<medicoDTO> getMedicoById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.service.getMedicoById(id));
    }

    @PostMapping
    public ResponseEntity createMedico(@RequestBody Medico Medico) {
        this.service.addMedico(Medico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Medico.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<medicoDTO> updateMedico(@PathVariable Long id, @RequestBody Medico Medico) {
        medicoDTO medico = this.service.updateMedico(id, Medico);
        return ResponseEntity.ok().body(medico);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteMedico(@PathVariable Long id) {
        this.service.removeMedico(id);
        return ResponseEntity.noContent().build();
    }
}
