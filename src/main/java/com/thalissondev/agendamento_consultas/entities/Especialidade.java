package com.thalissondev.agendamento_consultas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_especialidade")
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "especialidade")
    private List<Consulta> consultas = new ArrayList<>();

    @OneToMany(mappedBy = "especialidade")
    private List<Consulta> medicos = new ArrayList<>();
}
