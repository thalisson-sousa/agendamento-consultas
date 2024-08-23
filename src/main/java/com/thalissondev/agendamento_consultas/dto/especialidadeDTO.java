package com.thalissondev.agendamento_consultas.dto;

import com.thalissondev.agendamento_consultas.entities.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class especialidadeDTO {
    private Long id;
    private String name;

    public especialidadeDTO(Especialidade especialidade) {
        this.id = especialidade.getId();
        this.name = especialidade.getName();
    }
}
