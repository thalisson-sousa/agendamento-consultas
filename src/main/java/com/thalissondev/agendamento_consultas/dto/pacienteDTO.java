package com.thalissondev.agendamento_consultas.dto;

import com.thalissondev.agendamento_consultas.entities.Paciente;
import com.thalissondev.agendamento_consultas.util.GeneroType;

import java.util.Date;

public class pacienteDTO {
    private Long id;
    private String name;
    private Date nascimento;
    private GeneroType genero ;
    private String identificacao;
    private String numSus;
    private String contato;
    private String email;
    private String endereco;

    public pacienteDTO() {}

    public pacienteDTO(Paciente Paciente) {
        this.id = Paciente.getId();
        this.name = Paciente.getName();
        this.nascimento = Paciente.getNascimento();
        this.genero = Paciente.getGenero();
        this.identificacao = Paciente.getIdentificacao();
        this.numSus = Paciente.getNumSus();
        this.contato = Paciente.getContato();
        this.email = Paciente.getEmail();
        this.endereco = Paciente.getEndereco();
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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public GeneroType getGenero() {
        return genero;
    }

    public void setGenero(GeneroType genero) {
        this.genero = genero;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getNumSus() {
        return numSus;
    }

    public void setNumSus(String numSus) {
        this.numSus = numSus;
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
