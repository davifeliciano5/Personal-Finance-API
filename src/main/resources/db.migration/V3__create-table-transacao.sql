CREATE TABLE transacao(
    id_transacao SERIAL PRIMARY KEY,
    descricao TEXT NOT NULL,
    valor DECIMAL NOT NULL,
    tipo    TEXT CHECK (tipo IN ('INCOME', 'EXPENSE')),
    data DATE NOT NULL,
    fk_categoria INTEGER NOT NULL,
    fk_usuario INTEGER NOT NULL,

    FOREIGN KEY (fk_categoria) REFERENCES categorias (id_categoria),
    FOREIGN KEY (fk_usuario) REFERENCES usuarios (id_usuario)
);