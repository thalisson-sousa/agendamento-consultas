package com.thalissondev.agendamento_consultas.controllers;

import com.thalissondev.agendamento_consultas.dto.especialidadeDTO;
import com.thalissondev.agendamento_consultas.entities.Especialidade;
import com.thalissondev.agendamento_consultas.services.especialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "gdc/especialidade")
public class especialidadeController {

    @Autowired
    private especialidadeService service;

    @GetMapping
    public ResponseEntity<Page<especialidadeDTO>> getPacientes(Pageable pageable) {
        return ResponseEntity.ok().body(this.service.getEspecialidades(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<especialidadeDTO> getPacienteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.service.getPEspecialidade(id));
    }

    @PostMapping
    public ResponseEntity createPaciente(@RequestBody Especialidade especialidade) {
        this.service.addEspecialidade(especialidade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(especialidade.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<especialidadeDTO> updatePaciente(@PathVariable Long id, @RequestBody Especialidade especialidade) {
        especialidadeDTO Especialidade = this.service.updateEspecialidade(id, especialidade);
        return ResponseEntity.ok().body(Especialidade);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePaciente(@PathVariable Long id) {
        this.service.removeEspecialidade(id);
        return ResponseEntity.noContent().build();
    }
}
