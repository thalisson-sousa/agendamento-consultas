CREATE TABLE tb_medico (
    id BIGSERIAL PRIMARY KEY,
    especialidade_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    identificacao VARCHAR(100),
    contato VARCHAR(50),
    email VARCHAR(255),
    endereco TEXT,

    CONSTRAINT fk_especialidade FOREIGN KEY (especialidade_id) REFERENCES tb_especialidade(id)
);
