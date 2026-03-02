CREATE TABLE categorias(
    id_categoria SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    fk_categoria_usuario INTEGER NOT NULL,
    FOREIGN KEY (fk_categoria_usuario) REFERENCES usuarios (id_usuario)
);