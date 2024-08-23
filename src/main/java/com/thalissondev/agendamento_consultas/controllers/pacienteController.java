package com.thalissondev.agendamento_consultas.controllers;

import com.thalissondev.agendamento_consultas.dto.pacienteDTO;
import com.thalissondev.agendamento_consultas.entities.Paciente;
import com.thalissondev.agendamento_consultas.services.pacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "gdc/paciente")
public class pacienteController {

    @Autowired
    private pacienteService service;

    @GetMapping
    public ResponseEntity<List<pacienteDTO>> getPacientes() {
        return ResponseEntity.ok().body(this.service.getPacientes());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<pacienteDTO> getPacienteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.service.getPaciente(id));
    }

    @PostMapping
    public ResponseEntity createPaciente(@RequestBody Paciente paciente) {
        this.service.addPaciente(paciente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<pacienteDTO> updatePaciente(@PathVariable Long id, @RequestBody Paciente Paciente) {
        pacienteDTO paciente = this.service.updatePaciente(id, Paciente);
        return ResponseEntity.ok().body(paciente);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePaciente(@PathVariable Long id) {
        this.service.removePaciente(id);
        return ResponseEntity.noContent().build();
    }
}
