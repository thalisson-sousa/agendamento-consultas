package com.thalissondev.agendamento_consultas.entities;

import com.thalissondev.agendamento_consultas.util.PrioridadeType;
import com.thalissondev.agendamento_consultas.util.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.File;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_consulta")
public class Consulta {
    // Detalhes da Consulta:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;

    private String data;
    private String type;
    private String motivoConsulta;

    //Status da Consulta:
    private StatusType status;
    private PrioridadeType prioridade;

    //Informações Financeiras:
    private String valorConsulta;

    //Notas e Observações:
    private String observacoesMedicas;
    private File anexo;
}
