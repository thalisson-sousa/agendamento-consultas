CREATE TABLE tb_paciente (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    nascimento DATE NOT NULL,
    genero VARCHAR(50),
    identificacao VARCHAR(100),
    num_sus VARCHAR(15),
    contato VARCHAR(50),
    email VARCHAR(255),
    endereco TEXT
);
