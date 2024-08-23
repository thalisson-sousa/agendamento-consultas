CREATE TABLE tb_consulta (
    id BIGSERIAL PRIMARY KEY,
    paciente_id BIGINT NOT NULL,
    medico_id BIGINT NOT NULL,
    especialidade_id BIGINT NOT NULL,
    data VARCHAR(20) NOT NULL,
    type VARCHAR(50),
    motivo_consulta TEXT,
    status VARCHAR(50),
    prioridade VARCHAR(50),
    valor_consulta VARCHAR(20),
    observacoes_medicas TEXT,
    anexo BYTEA,

    CONSTRAINT fk_paciente FOREIGN KEY (paciente_id) REFERENCES tb_paciente(id),
    CONSTRAINT fk_medico FOREIGN KEY (medico_id) REFERENCES tb_medico(id),
    CONSTRAINT fk_especialidade FOREIGN KEY (especialidade_id) REFERENCES tb_especialidade(id)
);
