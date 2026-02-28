CREATE TABLE usuarios(
    id_usuario SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT  UNIQUE NOT NULL CHECK (email <> ''),
    password TEXT NOT NULL
);