package com.thalissondev.agendamento_consultas.dto;

import com.thalissondev.agendamento_consultas.entities.Especialidade;
import com.thalissondev.agendamento_consultas.entities.Medico;

public class medicoDTO {
    private Long id;
    private String name;
    private Long especializacaoId;
    private String especializacaoName;
    private String identificacao;
    private String contato;
    private String email;
    private String endereco;

    public medicoDTO() {}

    public medicoDTO(Medico Medico) {
        this.id = Medico.getId();
        this.name = Medico.getName();
        this.especializacaoId = Medico.getEspecialidade().getId();
        this.especializacaoName = Medico.getEspecialidade().getName();
        this.identificacao = Medico.getIdentificacao();
        this.contato = Medico.getContato();
        this.email = Medico.getEmail();
        this.endereco = Medico.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEspecializacaoId() {
        return especializacaoId;
    }

    public void setEspecializacaoId(Long especializacaoId) {
        this.especializacaoId = especializacaoId;
    }

    public String getEspecializacaoName() {
        return especializacaoName;
    }

    public void setEspecializacaoName(String especializacaoName) {
        this.especializacaoName = especializacaoName;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
