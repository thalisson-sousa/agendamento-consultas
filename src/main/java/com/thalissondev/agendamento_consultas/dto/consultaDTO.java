package com.thalissondev.agendamento_consultas.dto;
import com.thalissondev.agendamento_consultas.entities.Consulta;
import com.thalissondev.agendamento_consultas.entities.Especialidade;
import com.thalissondev.agendamento_consultas.entities.Medico;
import com.thalissondev.agendamento_consultas.entities.Paciente;
import com.thalissondev.agendamento_consultas.util.PrioridadeType;
import com.thalissondev.agendamento_consultas.util.StatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.File;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class consultaDTO {
    private Long id;
    private Long pacienteId;
    private String pacienteNome;
    private Long medicoId;
    private String medicoNome;
    private Long especialidadeId;
    private String especialidadeNome;
    private String data;
    private String type;
    private String motivoConsulta;
    private StatusType status;
    private PrioridadeType prioridade;
    private String valorConsulta;
    private String observacoesMedicas;
    private File anexo;

    public consultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.pacienteId = consulta.getPaciente().getId();
        this.pacienteNome = consulta.getPaciente().getName();
        this.medicoId = consulta.getMedico().getId();
        this.medicoNome = consulta.getMedico().getName();
        this.especialidadeId = consulta.getEspecialidade().getId();
        this.especialidadeNome = consulta.getEspecialidade().getName();
        this.data = consulta.getData();
        this.type = consulta.getType();
        this.motivoConsulta = consulta.getMotivoConsulta();
        this.status = consulta.getStatus();
        this.prioridade = consulta.getPrioridade();
        this.valorConsulta = consulta.getValorConsulta();
        this.observacoesMedicas = consulta.getObservacoesMedicas();
        this.anexo = consulta.getAnexo();
    }
}
