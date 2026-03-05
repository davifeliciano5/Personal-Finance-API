CREATE TABLE categorias (
    id_categoria BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    fk_categoria_usuario BIGINT NOT NULL,

    CONSTRAINT fk_categoria_usuario
        FOREIGN KEY (fk_categoria_usuario)
        REFERENCES usuarios(id_usuario)
        ON DELETE CASCADE
);
