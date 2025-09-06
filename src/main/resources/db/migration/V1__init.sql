CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255)
);
CREATE TABLE pelicula (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200),
    descripcion TEXT,
    genero VARCHAR(50),
    duracion INT
);
CREATE TABLE horario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora DATETIME
);
CREATE TABLE sala (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    capacidad INT
);
CREATE TABLE reserva (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT,
    pelicula_id BIGINT,
    horario_id BIGINT,
    sala_id BIGINT,
    codigo_acceso VARCHAR(50),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (pelicula_id) REFERENCES pelicula(id),
    FOREIGN KEY (horario_id) REFERENCES horario(id),
    FOREIGN KEY (sala_id) REFERENCES sala(id)
);
