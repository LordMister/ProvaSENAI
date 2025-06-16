CREATE DATABASE BIBLIOTECA;

USE BIBLIOTECA;

CREATE TABLE bibliotecario (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
email VARCHAR(50) NOT NULL

);

CREATE TABLE livro (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
bibliotecario_id BIGINT,
titulo VARCHAR(50) NOT NULL,
autor VARCHAR(30) NOT NULL,
genero VARCHAR(20) NOT NULL,
status VARCHAR(50) NOT NULL DEFAULT 'Disponível',
data_cadastro DATE,

FOREIGN KEY (bibliotecario_id) REFERENCES bibliotecario(id)
);

INSERT INTO bibliotecario (nome, email) VALUES
('Ana Paula', 'ana.paula@email.com'),
('Carlos Silva', 'carlos.silva@email.com'),
('Juliana Rocha', 'juliana.rocha@email.com'),
('Fernando Souza', 'fernando.souza@email.com');

INSERT INTO livro (bibliotecario_id, titulo, autor, genero, status, data_cadastro) VALUES
(4, 'Rei arthur', 'ricardo', 'ação', 'ocupado', '2025-10-18');



