CREATE TABLE transacao (
    id_transacao BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    tipo ENUM('INCOME', 'EXPENSE') NOT NULL,
    data DATE NOT NULL,
    fk_categoria BIGINT NOT NULL,
    fk_usuario BIGINT NOT NULL,

    CONSTRAINT fk_transacao_categoria
        FOREIGN KEY (fk_categoria)
        REFERENCES categorias(id_categoria)
        ON DELETE CASCADE,

    CONSTRAINT fk_transacao_usuario
        FOREIGN KEY (fk_usuario)
        REFERENCES usuarios(id_usuario)
        ON DELETE CASCADE
);