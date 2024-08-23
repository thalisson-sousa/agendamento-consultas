package com.thalissondev.agendamento_consultas.entities;

import com.thalissondev.agendamento_consultas.util.GeneroType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date nascimento;
    private GeneroType genero ;
    private String identificacao;

    @Column(name = "num_sus")
    private String numSus;

    private String contato;
    private String email;
    private String endereco;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas = new ArrayList<>();
}
